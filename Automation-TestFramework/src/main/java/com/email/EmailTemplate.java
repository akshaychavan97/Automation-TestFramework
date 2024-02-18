package com.email;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmailTemplate {
    private String template=System.getProperty("user.dir")+"\\test\\resources\\EmailTemplate.html";
    String path=System.getProperty("user.dir")+"\\src\\test\\resources\\EmailResource.html";
    public void createEmailHtml(String path) throws IOException {
        File input = new File(template);
        FileUtils.copyFile(input, new File(path));
    }
    public  void updateHtmlFile(String filePath,String newApplicationName,String region,int newPassedTestCases,
                                      int newFailedTestCases, int newSkippedTestCases,int totalTestCase) {
        try {
            // Load the HTML file using Jsoup
            File input = new File(filePath);
            Document doc = Jsoup.parse(input, "UTF-8");

            // Update application name
            Element appNameElement = doc.select("li:contains(Application)").first();
            if (appNameElement != null) {
                appNameElement.text("Application: " + newApplicationName);
            }
            Element regionElement = doc.select("li:contains(Region)").first();
            if (regionElement != null) {
                regionElement.text("Region: " + region);
            }

            // Update test case summary
            Element passedElement = doc.select("li:contains(Passed Test Cases)").first();
            if (passedElement != null) {
                passedElement.text("Passed Test Cases: " + newPassedTestCases);
            }

            Element failedElement = doc.select("li:contains(Failed Test Cases)").first();
            if (failedElement != null) {
                failedElement.text("Failed Test Cases: " + newFailedTestCases);
            }

            Element skippedElement = doc.select("li:contains(Skipped Test Cases)").first();
            if (skippedElement != null) {
                skippedElement.text("Skipped Test Cases: " + newSkippedTestCases);
            }
            Element totalElement = doc.select("li:contains(Total Test Cases)").first();
            if (totalElement != null) {
                totalElement.text("Total Test Cases: " + totalTestCase);
            }
            updateBarGraphValues(doc, newPassedTestCases, newFailedTestCases, newSkippedTestCases);
            Files.write(Paths.get(filePath), doc.outerHtml().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void addTableRow(String filePath, String testCaseName, String startTime, String endTime,
                                   int totalTime, String status, String browserName) {
        try {
            // Load the HTML file using Jsoup
            File input = new File(filePath);
            Document doc = Jsoup.parse(input, "UTF-8");

            // Select the table body
            Element tableBody = doc.select("tbody").first();

            // Create a new table row
            Element newRow = tableBody.appendElement("tr");

            // Add cells to the new row
            newRow.appendElement("td").text(testCaseName);
            newRow.appendElement("td").text(startTime);
            newRow.appendElement("td").text(endTime);
            newRow.appendElement("td").text(String.valueOf(totalTime));
            newRow.appendElement("td").text(status);
            newRow.appendElement("td").text(browserName);

            // Save the updated HTML content to the same file
            Files.write(Paths.get(filePath), doc.outerHtml().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void updateBarGraphValues(Document doc, int newPassedTestCases, int newFailedTestCases, int newSkippedTestCases) {
        // Calculate percentages
        int totalTestCases = newPassedTestCases + newFailedTestCases + newSkippedTestCases;
        double passedPercentage = (double) newPassedTestCases / totalTestCases * 100;
        double failedPercentage = (double) newFailedTestCases / totalTestCases * 100;
        double skippedPercentage = (double) newSkippedTestCases / totalTestCases * 100;

        // Update bar graph values
        updateBarGraphValue(doc, ".bar-green", newPassedTestCases, passedPercentage);
        updateBarGraphValue(doc, ".bar-red", newFailedTestCases, failedPercentage);
        updateBarGraphValue(doc, ".bar-yellow", newSkippedTestCases, skippedPercentage);
    }

    private static void updateBarGraphValue(Document doc, String selector, int count, double percentage) {
        Element barElement = doc.select(selector).first();
        if (barElement != null) {
            // Update the flex-basis attribute based on the percentage
            barElement.attr("style", "flex-basis: " + percentage + "%;");
            // Update the text inside the bar with the new count
            barElement.select(".bar-text").text();
        }
    }
}
