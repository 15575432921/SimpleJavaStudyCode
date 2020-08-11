package boot.spring.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.pagemodel.ActorGrid;
import boot.spring.pagemodel.MSG;
import boot.spring.po.Actor;
import boot.spring.service.ActorService;
import boot.spring.tools.FtpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "演员接口")
@Controller
public class ActorController {
	@Autowired
	private ActorService actorservice;
    private static final Logger LOG = LoggerFactory.getLogger(ActorController.class);
    @ApiOperation("把演员导出为Excel")
    @RequestMapping(value="/exportactor",method = RequestMethod.POST)
    @ResponseBody
    public void export(HttpServletResponse response,@RequestBody HashMap<String, String> a) throws Exception {
        InputStream is=actorservice.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename=AllUsers.xls");
        ServletOutputStream output=response.getOutputStream();
        IOUtils.copy(is,output);
    }
}
