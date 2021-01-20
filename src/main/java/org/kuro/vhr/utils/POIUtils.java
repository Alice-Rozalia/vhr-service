package org.kuro.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.kuro.vhr.model.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/20 17:11
 */
public class POIUtils {

    public static ResponseEntity<byte[]> employeeToExcel(List<Employee> list) {
        // 创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建文档摘要
        workbook.createInformationProperties();

        // 获取并配置文档摘要信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        // 文档类别
        docInfo.setCategory("员工信息");
        // 文档管理员
        docInfo.setManager("Kuro");
        // 公司信息
        docInfo.setCompany("www.kuro.org");

        // 获取文档摘要信息
        SummaryInformation summaryInfo = workbook.getSummaryInformation();
        // 文档的标题
        summaryInfo.setTitle("员工信息表");
        // 文档的作者
        summaryInfo.setAuthor("Kuro");
        // 文档的备注
        summaryInfo.setComments("本文档由 Kuro 提供");

        // 创建样式，创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.BLUE1.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFSheet sheet = workbook.createSheet("员工信息表");

        // 设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 5 * 256);
        sheet.setColumnWidth(5, 15 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 6 * 256);
        sheet.setColumnWidth(8, 5 * 256);
        sheet.setColumnWidth(9, 8 * 256);
        sheet.setColumnWidth(10, 8 * 256);
        sheet.setColumnWidth(11, 30 * 256);
        sheet.setColumnWidth(12, 15 * 256);
        sheet.setColumnWidth(13, 30 * 256);
        sheet.setColumnWidth(14, 8 * 256);
        sheet.setColumnWidth(15, 9 * 256);
        sheet.setColumnWidth(16, 9 * 256);
        sheet.setColumnWidth(17, 7 * 256);
        sheet.setColumnWidth(18, 10 * 256);
        sheet.setColumnWidth(19, 10 * 256);
        sheet.setColumnWidth(20, 10 * 256);
        sheet.setColumnWidth(21, 10 * 256);
        sheet.setColumnWidth(22, 8 * 256);
        sheet.setColumnWidth(23, 10 * 256);
        sheet.setColumnWidth(24, 5 * 256);
        sheet.setColumnWidth(25, 5 * 256);

        // 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);

        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");

        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("工号");

        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("状态");

        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("性别");

        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("出生日期");

        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("身份证号码");

        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("婚姻状况");

        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("民族");

        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("籍贯");

        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("政治面貌");

        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("电子邮件");

        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("电话号码");

        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("联系地址");

        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("所属部门");

        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("职位");

        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("职称");

        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("聘用形式");

        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("入职日期");

        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("转正日期");

        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("合同起始时间");

        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("合同终止时间");

        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("合同期限（年）");

        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("毕业学校");

        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("专业");

        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(headerStyle);
        c25.setCellValue("最高学历");

        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkId());
            row.createCell(3).setCellValue(emp.getWorkState());
            row.createCell(4).setCellValue(emp.getGender());
            row.createCell(5).setCellValue(emp.getBirthday());
            row.createCell(6).setCellValue(emp.getIdCard());
//            row.createCell(7).setCellValue();
//            row.createCell(8).setCellValue();
//            row.createCell(9).setCellValue();
//            row.createCell(10).setCellValue();
//            row.createCell(11).setCellValue();
//            row.createCell(12).setCellValue();
//            row.createCell(13).setCellValue();
//            row.createCell(14).setCellValue();
//            row.createCell(15).setCellValue();
//            row.createCell(16).setCellValue();
//            row.createCell(17).setCellValue();
//            row.createCell(18).setCellValue();
//            row.createCell(19).setCellValue();
//            row.createCell(20).setCellValue();
//            row.createCell(21).setCellValue();
//            row.createCell(22).setCellValue();
//            row.createCell(23).setCellValue();
//            row.createCell(24).setCellValue();
//            row.createCell(25).setCellValue();
        }
        return null;
    }

}
