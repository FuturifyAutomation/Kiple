package supports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import configurations.TestInitiation;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExcelReport implements ITestListener{

    AndroidDriver driver;
    public int numberPassedTests=0;
    public int numberFailedTests=0;
    public int numberSkipTest=0;
    public long durations=0;
    public String reportPath="./src/test/java/reports/";
    public HashMap<String,HashMap<String, String>> suiteResult = new HashMap<String,HashMap<String, String>>();

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long tcDuration =result.getEndMillis()-result.getStartMillis();
        numberPassedTests ++;
//        durations=durations+tcDuration/60;
        durations+=tcDuration;
        HashMap<String,String> testResult=new HashMap<String,String>();
        testResult.put("TC_Name", getTestMethodName(result));
        testResult.put("Result", "Passed");
//        testResult.put("Durations", String.valueOf(tcDuration/60));
        testResult.put("Durations", String.valueOf(tcDuration));
        suiteResult.put(getTestMethodName(result), testResult);
    }

    @Override
    public void onTestFailure(ITestResult result){
        long tcDuration =result.getEndMillis()-result.getStartMillis();
        numberFailedTests ++;
        durations+=tcDuration;
        HashMap<String,String> testResult=new HashMap<String,String>();
        testResult.put("TC_Name", getTestMethodName(result));
        testResult.put("Result", "Failed");
        testResult.put("Error_Log", result.getThrowable().toString());
        testResult.put("Durations", String.valueOf(tcDuration));
        suiteResult.put(getTestMethodName(result), testResult);

////        Initiate driver for all classes
//        this.driver = ((TestInitiation)result.getInstance()).androidDriver;
//
////        Take screenshot
//        String currentTime=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        String fileName=reportPath + "Screenshot_" + result.getTestClass().getName().substring(8) + "_" + result.getName() + "_" + currentTime + ".png";
//        File image =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(image, new File(fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        long tcDuration =result.getEndMillis()-result.getStartMillis();
        numberSkipTest ++;
        durations+=tcDuration;
        HashMap<String,String> testResult=new HashMap<String,String>();
        testResult.put("TC_Name", getTestMethodName(result));
        testResult.put("Result", "Skipped");
        testResult.put("Error_Log", result.getThrowable().toString());
        testResult.put("Durations", String.valueOf(tcDuration));
        suiteResult.put(getTestMethodName(result), testResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext context) {
        String finishTime=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName=reportPath + "Report_" + context.getName() + "_" + context.getAllTestMethods()[0].getInstance().getClass().getSimpleName() + "_" + finishTime + ".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create sheet Result
        XSSFSheet sheet = workbook.createSheet("RESULTS");

        // Create format for cell style
        XSSFCellStyle cellStyle = createCellStyle(sheet);

        // Failed newTestCase format
        XSSFCellStyle failedStyle = sheet.getWorkbook().createCellStyle();
        Font failedfont = sheet.getWorkbook().createFont();
        ((XSSFFont) failedfont).setBold(true);
        failedfont.setColor(IndexedColors.RED.getIndex());
        failedfont.setFontHeightInPoints((short) 13);
        failedStyle.setFont(failedfont);
        failedStyle.setAlignment(HorizontalAlignment.CENTER);
        failedStyle.setBorderBottom(CellStyle.BORDER_THIN);
        failedStyle.setBorderTop(CellStyle.BORDER_THIN);
        failedStyle.setBorderLeft(CellStyle.BORDER_THIN);
        failedStyle.setBorderRight(CellStyle.BORDER_THIN);


        // Passed newTestCase format
        XSSFCellStyle passedStyle = sheet.getWorkbook().createCellStyle();
        Font passedfont = sheet.getWorkbook().createFont();
        ((XSSFFont) passedfont).setBold(true);
        passedfont.setColor(IndexedColors.GREEN.getIndex());
        passedfont.setFontHeightInPoints((short) 13);
        passedStyle.setFont(passedfont);
        passedStyle.setAlignment(HorizontalAlignment.CENTER);
        passedStyle.setBorderBottom(CellStyle.BORDER_THIN);
        passedStyle.setBorderTop(CellStyle.BORDER_THIN);
        passedStyle.setBorderLeft(CellStyle.BORDER_THIN);
        passedStyle.setBorderRight(CellStyle.BORDER_THIN);


        // Normal newTestCase format
        XSSFCellStyle normalStyle = sheet.getWorkbook().createCellStyle();
        Font normalfont = sheet.getWorkbook().createFont();
        ((XSSFFont) normalfont).setBold(true);
        passedfont.setColor(IndexedColors.BLACK.getIndex());
        passedfont.setFontHeightInPoints((short) 13);
        normalStyle.setFont(passedfont);
        normalStyle.setAlignment(HorizontalAlignment.CENTER);
        normalStyle.setBorderBottom(CellStyle.BORDER_THIN);
        normalStyle.setBorderTop(CellStyle.BORDER_THIN);
        normalStyle.setBorderLeft(CellStyle.BORDER_THIN);
        normalStyle.setBorderRight(CellStyle.BORDER_THIN);

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        Row titleRow = sheet.createRow(0);
        Cell cellTitle=titleRow.createCell(0);
        cellTitle.setCellStyle(cellStyle);
        cellTitle.setCellValue("SUMMARY");

        Row summaryRow = sheet.createRow(1);
        Row summaryRowDetails = sheet.createRow(2);

        Cell passedCell=summaryRow.createCell(0);
        passedCell.setCellStyle(cellStyle);
        passedCell.setCellValue("PASSED");
        Cell numberPassTests = summaryRowDetails.createCell(0);
        numberPassTests.setCellStyle(normalStyle);
        numberPassTests.setCellValue(numberPassedTests);

        Cell failedCell=summaryRow.createCell(1);
        failedCell.setCellStyle(cellStyle);
        failedCell.setCellValue("FAILED");
        Cell numberFailTests = summaryRowDetails.createCell(1);
        numberFailTests.setCellStyle(normalStyle);
        numberFailTests.setCellValue(numberFailedTests);


        Cell NACell=summaryRow.createCell(2);
        NACell.setCellStyle(cellStyle);
        NACell.setCellValue("SKIPPED");
        Cell numberSkipTests = summaryRowDetails.createCell(2);
        numberSkipTests.setCellStyle(normalStyle);
        numberSkipTests.setCellValue(numberSkipTest);

        Cell totalCell=summaryRow.createCell(3);
        totalCell.setCellStyle(cellStyle);
        totalCell.setCellValue("TOTAL");
        Cell totalTests = summaryRowDetails.createCell(3);
        totalTests.setCellStyle(normalStyle);
        totalTests.setCellValue(numberPassedTests + numberFailedTests + numberSkipTest);

        Cell passrateCell=summaryRow.createCell(4);
        passrateCell.setCellStyle(cellStyle);
        passrateCell.setCellValue("PASS RATE");

        XSSFCellStyle passrate=sheet.getWorkbook().createCellStyle();
        passrate.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
        passrate.setBorderBottom(CellStyle.BORDER_THIN);
        passrate.setBorderTop(CellStyle.BORDER_THIN);
        passrate.setBorderLeft(CellStyle.BORDER_THIN);
        passrate.setBorderRight(CellStyle.BORDER_THIN);
        Cell passrateValue = summaryRowDetails.createCell(4);
        passrateValue.setCellStyle(passrate);
        passrateValue.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        passrateValue.setCellFormula("A3/SUM(A3:C3)");


        Cell durationsCell=summaryRow.createCell(5);
        durationsCell.setCellStyle(cellStyle);
        durationsCell.setCellValue("DURATIONS(M)");
        Cell durationsTime = summaryRowDetails.createCell(5);
        durationsTime.setCellStyle(normalStyle);
        long minute = durations/60000;
        long module = durations%60000;
        long second = module/1000;
        long millisecond = module;
        if (durations < 1000){
            millisecond = durations;
        }else if (durations >= 1000 & second != 0){
            millisecond = module%(second*1000);
        }
        durationsTime.setCellValue(minute + ":" + second + ":" + millisecond);

//	        Detail results
        sheet.addMergedRegion(new CellRangeAddress(4,4,0,5));
        titleRow = sheet.createRow(4);
        cellTitle=titleRow.createCell(0);
        cellTitle.setCellStyle(cellStyle);
        cellTitle.setCellValue("DETAILS");

        Row detailRow = sheet.createRow(5);


        Cell oderCell=detailRow.createCell(0);
        oderCell.setCellStyle(cellStyle);
        oderCell.setCellValue("No.");

        Cell featureCell=detailRow.createCell(1);
        featureCell.setCellStyle(cellStyle);
        featureCell.setCellValue("Device Name");

        Cell TCName=detailRow.createCell(2);
        TCName.setCellStyle(cellStyle);
        TCName.setCellValue("Test Name");


        Cell result=detailRow.createCell(3);
        result.setCellStyle(cellStyle);
        result.setCellValue("Result");

        Cell log=detailRow.createCell(4);
        log.setCellStyle(cellStyle);
        log.setCellValue("Error Logs");

        Cell durations=detailRow.createCell(5);
        durations.setCellStyle(cellStyle);
        durations.setCellValue("Durations(ms)");
        int noNum=1;
        int firstRow=6;
        for(String key: suiteResult.keySet()){
            Row tcDetails= sheet.createRow(firstRow);
            Cell noCell=tcDetails.createCell(0);
            noCell.setCellStyle(normalStyle);
            noCell.setCellValue(noNum);

            Cell feaCell=tcDetails.createCell(1);
            feaCell.setCellStyle(normalStyle);
            feaCell.setCellValue(context.getName());

            Cell testName=tcDetails.createCell(2);
            testName.setCellStyle(normalStyle);
            testName.setCellValue(suiteResult.get(key).get("TC_Name"));

            Cell cellResult = tcDetails.createCell(3);
            cellResult.setCellStyle(normalStyle);
            Cell cellErrorLog = tcDetails.createCell(4);
            cellErrorLog.setCellStyle(normalStyle);
            if (suiteResult.get(key).get("Result")=="Failed" | suiteResult.get(key).get("Result")=="Skipped"){
                cellResult.setCellStyle(failedStyle);
                cellResult.setCellValue(suiteResult.get(key).get("Result"));
                cellErrorLog.setCellStyle(failedStyle);
                cellErrorLog.setCellValue(suiteResult.get(key).get("Error_Log"));
            }
            else{
                cellResult.setCellStyle(passedStyle);
                cellResult.setCellValue(suiteResult.get(key).get("Result"));

            }

            Cell durationCell = tcDetails.createCell(5);
            durationCell.setCellStyle(normalStyle);
            durationCell.setCellValue(suiteResult.get(key).get("Durations"));
            noNum++;
            firstRow++;
        }

        try  {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public XSSFCellStyle createCellStyle(XSSFSheet sheet) {
        XSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        ((XSSFFont) font).setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 13);
        cellStyle.setFont(font);
        XSSFColor Header = new XSSFColor(new java.awt.Color(53, 138, 65)); // #f2dcdb
        cellStyle.setFillForegroundColor(Header);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}