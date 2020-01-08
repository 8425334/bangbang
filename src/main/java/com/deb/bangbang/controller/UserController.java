package com.deb.bangbang.controller;

import com.deb.bangbang.bean.entity.User;
import com.deb.bangbang.bean.result.JsonResult;
import com.deb.bangbang.bean.vo.UserInfo;
import com.deb.bangbang.constant.enums.CodeEnum;
import com.deb.bangbang.service.UserService;
import com.deb.bangbang.util.DateUtil;
import com.deb.bangbang.util.HttpUtil;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseExtractor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.deb.bangbang.constant.Constant.BASE_URL;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/getUserInfo")
    public JsonResult getUserInfo(@RequestParam("openid")String openid ){
        @NotNull
        User user = userService.findUserByOpenid(openid);
        System.out.println("收到用户请求");
        if (user != null){
            //检验用户信息完整性
            if (user.getUserInfo().getStuId() == null
                    || user.getUserInfo().getName() == null
                    || user.getUserInfo().getIdentity() == null){
                return new JsonResult(CodeEnum.INFO_NOT_COMPLETE.getCode(), userService.findUserByOpenid(openid));
            }
            return new JsonResult(CodeEnum.SUCCESS.getCode(), user);
        }
        return new JsonResult(CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getDesc());
    }

    /**
     * 设置用户个人信息
     * @param openid
     * @param name
     * @param stuId
     * @param identity
     * @return
     */
    @GetMapping("/setUserInfo")
    public JsonResult setUserInfo(@RequestParam("openid")String openid,
                                  @RequestParam("name") String name,
                                  @RequestParam("stuId")String stuId,
                                  @RequestParam("identity")Integer identity){
        User user = userService.findUserByOpenid(openid);
        //openid不存在
        if (user == null){
            return new JsonResult(CodeEnum.OPENID_NOT_FOUND.getCode(), CodeEnum.OPENID_NOT_FOUND.getDesc());
        }else {
            //pojo保存信息
            user.setOpenid(openid);
            UserInfo userInfo = user.getUserInfo();
            userInfo.setName(name);
            userInfo.setStuId(stuId);
            userInfo.setIdentity(identity);
            user.setUserInfo(userInfo);
            userService.saveUser(user);
            return new JsonResult(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS);
        }
    }


    /**
     * 登录授权回调重定向
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/login")
    public String getWeChatLoginCode(@RequestParam("code") String code,
                                     @RequestParam("state") String state){

        //获取access token 和 openid
        try {
            String s = HttpUtil.getWeChatCode(code, state);
            //Json解析
            GsonJsonParser p = new GsonJsonParser();
            //装载Json解析的数据到哈希表
            Map<String, Object> map = p.parseMap(s);
            //获取access token
            String accessToken = (String)map.get("access_token");
            //获取openid
            String openId = (String)map.get("openid");
            //提交access token以及openid给微信服务器
            String json = HttpUtil.getWeChatOpenId(openId, accessToken);
            System.out.println(openId);
            System.out.println(json);
            //讲Json转换为POJO实例
            map = p.parseMap(json);

            if (userService.findUserByOpenid(openId) == null){
                User user = new User();
                user.setOpenid(openId);
                UserInfo info = new UserInfo();
                info.setCreateTime(DateUtil.getTime());
                info.setHeadImage((String)map.get("headimgurl"));
                user.setUserInfo(info);
                userService.saveUser(user);
            }
            //User user = gson.fromJson(json, User.class);
            final String REDIRECT_HOME_PARAM = BASE_URL + "/#/?openid=" + openId;
            return "<script>window.location.href='" + REDIRECT_HOME_PARAM +  "'</script>";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
