package trelloServiceTest.TestData;


import trelloServiceTest.webServiceAutomation.TrelloAPITest;

import java.util.HashMap;

public class TestDataTrello {
    public HashMap<String, String> postBoardData(){

        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key","7758a884d6a58f168bd9e010ab6d702b");
        postBodyMap.put("token","7b2c5fe4457fd6642cc758301673883648c326f1bfd55a22558ee064b8750a2b");
        postBodyMap.put("name", "Board01");
        return postBodyMap;
    }
    public HashMap<String, String> postListData(){

        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key","7758a884d6a58f168bd9e010ab6d702b");
        postBodyMap.put("token","7274a3c6e9e0d910deffd261b7d3f99cf6e872b18cf6a37defe3ca6c5dd4788f");
        postBodyMap.put("name","list01");
        postBodyMap.put("idBoard", TrelloAPITest.boardId);

        return postBodyMap;
    }

    public HashMap<String, String> postCardData(){

        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key","7758a884d6a58f168bd9e010ab6d702b");
        postBodyMap.put("token","7274a3c6e9e0d910deffd261b7d3f99cf6e872b18cf6a37defe3ca6c5dd4788f");
        postBodyMap.put("idList", TrelloAPITest.listId);

        return postBodyMap;
    }

    public HashMap<String, String> updateData(){

        HashMap<String,String> updateBodyMap=new HashMap<>();
        updateBodyMap.put("key","7758a884d6a58f168bd9e010ab6d702b");
        updateBodyMap.put("token","7274a3c6e9e0d910deffd261b7d3f99cf6e872b18cf6a37defe3ca6c5dd4788f");
        updateBodyMap.put("name", "update");

        return updateBodyMap;
    }

    public HashMap<String, String> delete(){

        HashMap<String,String> deleteMap=new HashMap<>();
        deleteMap.put("key","7758a884d6a58f168bd9e010ab6d702b");
        deleteMap.put("token","7274a3c6e9e0d910deffd261b7d3f99cf6e872b18cf6a37defe3ca6c5dd4788f");

        return deleteMap;
    }
}
