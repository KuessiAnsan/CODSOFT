package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("WELCOME TO THE CURRENCY CONVERTER APP");

        String codesRequestUrl = "https://v6.exchangerate-api.com/v6/396a01cd92eb64becddf94f2/codes";


        URL codesUrl = new URL(codesRequestUrl);
        HttpURLConnection codesRequest = (HttpURLConnection) codesUrl.openConnection();
        codesRequest.connect();
        JsonObject codesJsonResult = getJsonResult(codesRequest);
        JsonArray supported_codes = codesJsonResult.get("supported_codes").getAsJsonArray();


        System.out.println("These are the supported codes");

        for (JsonElement code:
             supported_codes) {
            System.out.println(code);
        }


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base currency code (Ex: USD, EUR) :");

        String baseCurrency = scanner.nextLine();

        System.out.println("Enter the target currency code (Ex: USD, EUR) :");

        String targetCurrency = scanner.nextLine();

        System.out.println("Enter the amount to convert :");

        double amountToConvert = scanner.nextDouble();


        String conversionRequestUrl = "https://v6.exchangerate-api.com/v6/396a01cd92eb64becddf94f2/pair/" + baseCurrency + "/" + targetCurrency + "/" + amountToConvert;


        URL url = new URL(conversionRequestUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonObject jsonResult = getJsonResult(request);

        String req_result = jsonResult.get("conversion_result").getAsString();


        System.out.println(amountToConvert + " " + baseCurrency + " = " + req_result + " " + targetCurrency);
    }

    public static JsonObject getJsonResult(HttpURLConnection request) throws IOException {
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonObject();
    }
}