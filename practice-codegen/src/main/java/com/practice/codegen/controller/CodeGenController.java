package com.practice.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.practice.codegen.common.R;
import com.practice.codegen.entity.GenConfig;
import com.practice.codegen.entity.TableRequest;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 * @author wb
 */
@RestController
@AllArgsConstructor
@RequestMapping("/generator")
public class CodeGenController {
    private final CodeGenService codeGenService;

    /**
     * 列表
     *
     * @param request 参数集
     * @return 数据库表
     */
    @GetMapping("/table")
    public R listTables(TableRequest request) {
        return R.success(codeGenService.listTables(request));
    }

    /**
     * 生成代码
     */
    @SneakyThrows
    @PostMapping("")
    public void generatorCode(@RequestBody GenConfig genConfig, HttpServletResponse response) {
        byte[] data = codeGenService.generatorCode(genConfig);

        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
    }
}