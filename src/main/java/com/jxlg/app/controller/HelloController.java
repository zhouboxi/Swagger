package com.jxlg.app.controller;

import com.jxlg.app.entity.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(value="TestController",description = "测试接口描述")
public class HelloController {

    /*
	 * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型", notes ="接口发布说明"
	 *
	 * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
	 * @ApiParam(required = true,name = "paramData",value = "用户信息 json 数据") String paramData
	 */
    @RequestMapping("/getUser")
    @ApiOperation(value="获取用户",httpMethod = "GET",response = User.class,notes="接口发布说明")
    public User getUser(){

        return new User("小明","深圳");
    }

    @RequestMapping("/saveUser")
    @ApiOperation(value="保存用户",httpMethod = "POST",response = User.class,consumes="application/x-www-form-urlencoded",notes="接口发布说明")
    public User saveUser(@ApiParam(required = true,name = "username",value = "用户信息") String username){
        User user = new User();
        user.setUsername(username);
        user.setAddress("北京");
        return user;
    }
}
