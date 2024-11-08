package org.ckj.mytemplate.controller;

import lombok.RequiredArgsConstructor;
import org.ckj.mytemplate.service.TemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-07  17:45
 * @Description: 模板控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("template")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

}
