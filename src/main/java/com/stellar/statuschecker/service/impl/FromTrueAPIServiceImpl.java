package com.stellar.statuschecker.service.impl;

import com.stellar.statuschecker.service.FromTrueAPIService;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FromTrueAPIServiceImpl implements FromTrueAPIService {
    @Override
    public String fromTrueAPI(MultipartFile file) throws IOException {

    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, file.getBytes());

    Request request = new Request.Builder()
            .url("https://true-api.teksher.kg/api/v3/true-api/cises/info")
            .method("POST", body)
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcm9kdWN0X2dyb3VwX2luZm8iOlt7Im5hbWUiOiJ0b2JhY2NvIiwic3RhdHVzIjoiNSIsInR5cGVzIjpbIlBST0RVQ0VSIiwiSU1QT1JURVIiLCJUUkFERV9QQVJUSUNJUEFOVCJdfSx7Im5hbWUiOiJhbGNvaG9sIiwic3RhdHVzIjoiNSIsInR5cGVzIjpbIlBST0RVQ0VSIiwiSU1QT1JURVIiLCJUUkFERV9QQVJUSUNJUEFOVCJdfV0sInVzZXJfc3RhdHVzIjoiQUNUSVZFIiwidXNlcl9uYW1lIjpudWxsLCJpbm4iOiIwMjcwNjIwMTExMDAyMSIsInBpZCI6MjQsImF1dGhvcml0aWVzIjpbIkNSUFQtS00tT1JERVJTLlBBUlRJQ0lQQU5ULldSSVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuU0hJUE1FTlQuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuTFBfUkVUVVJOLlJFQUQiLCJDUlBULUZBQ0FERS5ET0MtQ09OVFJPTExFUi5SRUFHR1JFR0FUSU9OLkNSRUFURSIsIlJPTEVfSEVBRF9UUCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlJFTUFSS0lORy5DUkVBVEUiLCJDUlBULUtNLU9SREVSUy5PUkRFUi1GQUNBREUtQ09OVFJPTExFUi5SRUFESU5HLUJZLU9QRVJBVE9SLkNSRUFURSIsIlJPTEVfT1JHX0lNUE9SVEVSIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuQ1JPU1NCT1JERVIuQ1JFQVRFIiwiQ1JQVC1MSy1ET0MtQVBJLkFERC1DRVJULUNPTlRST0xMRVIuQ1JFQVRFIiwiUk9MRV9VU0VSIiwiQ1JQVC1LTS1PUkRFUlMuT1JERVItRkFDQURFLUNPTlRST0xMRVIuUkVBRElORy1CWS1PUEVSQVRPUi5XUklURSIsIkVMSy1QUk9GSUxFLlJFQUQiLCJST0xFX09SR19UUkFERV9QQVJUSUNJUEFOVCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkNPTlRSQUNULUNPTU1JU1NJT05JTkcuQ1JFQVRFIiwiQ1JQVC1LTS1PUkRFUlMuT1BFUkFUT1IuV1JJVEUiLCJDUlBULUZBQ0FERS5ET0MtQ09OVFJPTExFUi5BQ0NFUFRBTkNFLlJFQUQiLCJST0xFX09SR1_Qo9GH0LDRgdGC0L3QuNC6INC-0LHQvtGA0L7RgtCwIiwiQ1JQVC1GQUNBREUuQ0lTLUNPTlRST0xMRVIuUkVQT1JULlJFQUQiLCJDUlBULUZBQ0FERS5DSVMtQ09OVFJPTExFUi5SRVBPUlQuRE9XTkxPQUQiLCJST0xFX1NVWiIsIkNSUFQtRkFDQURFLkFQUC1VU0VSLUNPTlRST0xMRVIuTElTVC1BQ1RJVkUuUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlNISVBNRU5ULlJFQUQiLCJDUlBULUZBQ0FERS5ET0MtQ09OVFJPTExFUi5PU1RfREVTQ1JJUFRJT04uQ1JFQVRFIiwiUk9MRV9PUkdfUFJPRFVDRVIiLCJDUlBULUtNLU9SREVSUy5PUkRFUi1GQUNBREUtQ09OVFJPTExFUi5SRUFESU5HLUJZLU9QRVJBVE9SLlJFQUQiLCJOQU1FLkNSRUFURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlJFQ0VJUFQuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuT1NUX0NPTVBMRVRFX0RFU0NSSVBUSU9OLkNSRUFURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLklNUE9SVC1DT01NSVNTSU9OSU5HLkNSRUFURSIsIlJPTEVfT1JHX9CY0LzQv9C-0YDRgtC10YAg0YLQvtCy0LDRgNCwIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuTFBfQ0FOQ0VMX1NISVBNRU5UX0NST1NTQk9SREVSLkNSRUFURSIsIkNSUFQtTEstRE9DLUFQSS5BUFAtVVNFUi1DT05UUk9MTEVSLkNSRUFURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlJFTUFSS0lORy5SRUFEIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuQ1JPU1NCT1JERVIuUkVBRCIsIkVMSy1SRUdJU1RSQVRJT04uUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkFDQ0VQVEFOQ0UuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuSU5ESS1DT01NSVNTSU9OSU5HLkNSRUFURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlNISVAtQ1JPU1NCT1JERVIuUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLk9TVF9ERVNDUklQVElPTi5SRUFEIiwiUk9MRV9BRE1JTiIsIkNSUFQtTEstRE9DLUFQSS5CTE9DS0lORy1DT05UUk9MTEVSLkNSRUFURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkxQX0lOVFJPRFVDRV9PU1QuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuUFJPRklMRS1DT05UUk9MTEVSLkNPTVBBTlkuUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkFHR1JFR0FUSU9OLkNSRUFURSIsIkNSUFQtS00tT1JERVJTLlBBUlRJQ0lQQU5ULU9SLU9QRVJBVE9SLldSSVRFIiwiQ1JQVC1LTS1PUkRFUlMuT1JERVItRkFDQURFLUNPTlRST0xMRVIuUkVBRElORy1CWS1PUEVSQVRPUi5BRE1JTklTVFJBVElPTiIsIkNSUFQtTEstRE9DLUFQSS5BUFAtVVNFUi1DT05UUk9MTEVSLkRFTEVURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkNPTU1JU1NJT05JTkcuUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkRJU0FHR1JFR0FUSU9OLlJFQUQiLCJDUlBULUZBQ0FERS5NQVJLRUQtUFJPRFVDVFMtQ09OVFJPTExFUi5SRUFEIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuQUdHUkVHQVRJT04uUkVBRCIsIkNSUFQtRkFDQURFLkFQUC1VU0VSLUNPTlRST0xMRVIuTElTVC1SRU1PVkVELlJFQUQiLCJOQU1FLlJFQUQiLCJDUlBULUZBQ0FERS5ET0MtQ09OVFJPTExFUi5LTS1BUFBMSUVELUNBTkNFTC5DUkVBVEUiLCJDUlBULUtNLU9SREVSUy5PUkRFUi1GQUNBREUtQ09OVFJPTExFUi5SRUFESU5HLUJZLU9QRVJBVE9SLkRFTEVURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkxQX0lOVFJPRFVDRV9PU1QuUkVBRCIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkNPTU1JU1NJT05JTkcuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuRElTQUdHUkVHQVRJT04uQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuTE9BTi5DUkVBVEUiLCJST0xFX09SR1_Qn9GA0L7QuNC30LLQvtC00LjRgtC10LvRjCIsIkNSUFQtS00tT1JERVJTLlNVWi5XUklURSIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLlNISVAtQ1JPU1NCT1JERVIuQ1JFQVRFIiwiSU5OXzAyNzA2MjAxMTEwMDIxIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuTFBfQ0FOQ0VMX1NISVBNRU5UX0NST1NTQk9SREVSLlJFQUQiLCJDUlBULUtNLU9SREVSUy5PUkRFUi1GQUNBREUtQ09OVFJPTExFUi5SRUFESU5HLUJZLU9QRVJBVE9SLkRPV05MT0FEIiwiRUxLLVJFR0lTVFJBVElPTi5XUklURSIsIkNSUFQtTEstRE9DLUFQSS5EUkFGVC5BRE1JTklTVFJBVElPTiIsIkNSUFQtRkFDQURFLkRPQy1DT05UUk9MTEVSLkxQX1JFVFVSTi5DUkVBVEUiLCJDUlBULUZBQ0FERS5QQVJUSUNJUEFOVC1DT05UUk9MTEVSLkdFVC1CWS1JTk4uUkVBRCIsIkNSUFQtRkFDQURFLkNJUy1DT05UUk9MTEVSLlNFQVJDSC5SRUFEIiwiQ1JQVC1GQUNBREUuUFJPRklMRS1DT05UUk9MTEVSLkNPTVBBTlkuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuUkVBR0dSRUdBVElPTi5SRUFEIiwiQ1JQVC1LTS1PUkRFUlMuUEFSVElDSVBBTlQtT1ItT1BFUkFUT1IuUkVBRCIsIkNSUFQtTEstRE9DLUFQSS5SRVNVTUUtQUNDRVNTLUNPTlRST0xMRVIuQ1JFQVRFIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuTE9BTi5SRUFEIiwiQ1JQVC1GQUNBREUuRE9DLUNPTlRST0xMRVIuT1NUX0NPTVBMRVRFX0RFU0NSSVBUSU9OLlJFQUQiLCJFTEstUkVHSVNUUkFUSU9OLkNSRUFURSIsIkNSUFQtTEstRE9DLUFQSS5BUFAtVVNFUi1DT05UUk9MTEVSLldSSVRFIiwiQ1JQVC1GQUNBREUuTUFSS0VELVBST0RVQ1RTLUNPTlRST0xMRVIuQURNSU5JU1RSQVRJT04iLCJDUlBULUZBQ0FERS5ET0MtQ09OVFJPTExFUi5LTS1DQU5DRUwuQ1JFQVRFIl0sImNsaWVudF9pZCI6ImNycHQtc2VydmljZSIsImZ1bGxfbmFtZSI6ItCd0YPRgNC70LDQvSDRg9GD0LvRgyDQmtC10YDQuNC8Iiwic2NvcGUiOlsidHJ1c3RlZCJdLCJpZCI6MzAsImV4cCI6MTYzMTE5MzI0OSwib3JnYW5pc2F0aW9uX3N0YXR1cyI6IlJFR0lTVEVSRUQiLCJqdGkiOiJkMmRlNDg3NC02ZDY5LTQ0MWUtODMyOC02NmU4YzllYWVkOWQifQ.h_6HsXXD-X-7epo7JhoVyAQRIavdts2BNvlya-vEIgY")
            .addHeader("Content-Type", "application/json")
            .build();
    Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        List<String> responseList = new ArrayList<>();
        responseList.add(String.valueOf(response.body().string()));
    return responseList.toString();

    }
}