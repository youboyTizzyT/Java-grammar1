package database.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Map;

public class MongoDbTest {
    public static void main( String args[] ){
        try{

            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "10.21.32.111" , 50216 );
            MongoClient mongoClient2 = new MongoClient( "10.21.32.111" , 50214 );

            // 连接到数据库
            MongoDatabase apppLink = mongoClient.getDatabase("APPLINK");
            MongoDatabase mobLink = mongoClient2.getDatabase("MOBLINK");

            // 获取需要更改的集合
            MongoCollection<Document> appConfNew=apppLink.getCollection("AppConfNew");
            MongoCollection<Document> appConf=apppLink.getCollection("AppConf");
            MongoCollection<Document> mobConf=mobLink.getCollection("AppConf");
            // 获取所有appconf和mobconf的信息
            FindIterable<Document> allAppConf=appConf.find();
            FindIterable<Document> allMobConf=mobConf.find();
            // 遍历所有的appconf
            for (Document anAllAppConf : allAppConf) {
                String appkey= (String) anAllAppConf.get("_id");
                // 查找是否是老版本存在
                Document anMobConf=findByKey(appkey,mobConf);
                // 查找是否已经更新过数据
                Document anAppConfNew=findByKey(appkey,appConfNew);
                // 已经迁移过数据的需要特殊处理
                if (anAppConfNew!=null){
                    System.out.println("已经迁移过的数据："+appkey);
                    continue;
                }
                // 没有迁移过数据的新版本
                appConfNew.insertOne(anAllAppConf);
                // 如果moblink有数据，就更新过去老数据
                if (anMobConf!=null) {
                    Document updata = moblink(anMobConf);
                    appConfNew.updateOne(Filters.eq("_id", appkey),new Document("$set",updata));
                }
            }
            System.out.println("+++++++++++++++++++++++++++++");
            // 把老数据，没有升级过的老数据迁移到迁移库中
            appConfNew=apppLink.getCollection("AppConfNew");
            for (Document anAllMobConf : allMobConf) {
                String appkey = (String) anAllMobConf.get("_id");
                Document anAppConf=findByKey(appkey,appConf);
                // 没有迁移过数据的老版本
                if (anAppConf==null){
                    Document aaa=moblink(anAllMobConf);
                    appConfNew.insertOne(aaa);
                }
//                else {
//                    appConfNew.insertOne(anAppConf);
//                    Document updata = moblink(anAllMobConf);
//                    appConfNew.updateOne(Filters.eq("_id", appkey),new Document("$set",updata));
//                }

            }
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    private static Document findByKey(String appkey, MongoCollection<Document> db){
        return db.find(Filters.eq("_id",appkey)).first();
    }
    private static Document moblink(Document oldAppConf){
        Document ret=new Document();
        ret.append("_id",oldAppConf.get("_id"));
        if (oldAppConf.get("appid")!=null)ret.append("oldAppid",oldAppConf.get("appid"));
        if (oldAppConf.get("apppkg")!=null)ret.append("oldPackageName",oldAppConf.get("apppkg"));
        if (oldAppConf.get("bundleId")!=null)ret.append("oldBundleId",oldAppConf.get("bundleId"));
        if (oldAppConf.get("teamId")!=null)ret.append("oldTeamId",oldAppConf.get("teamId"));
        if (oldAppConf.get("universalLink")!=null)ret.append("universalLink",oldAppConf.get("universalLink"));
        if (oldAppConf.get("deepLink")!=null)ret.append("deepLink",oldAppConf.get("deepLink"));
        if (oldAppConf.get("androidDownloadUrl")!=null)ret.append("oldAndroidDownload",oldAppConf.get("androidDownloadUrl"));
        if (oldAppConf.get("androidCustomDownload")!=null)ret.append("androidCustomDownload",oldAppConf.get("androidCustomDownload"));
        if (oldAppConf.get("iosDownloadUrl")!=null)ret.append("oldIosDownload",oldAppConf.get("iosDownloadUrl"));
        if (oldAppConf.get("iosCustomDownload")!=null)ret.append("iosCustomDownload",oldAppConf.get("iosCustomDownload"));
        if (oldAppConf.get("iosCustomGuide")!=null)ret.append("iosCustomGuide",oldAppConf.get("iosCustomGuide"));
        if (oldAppConf.get("yybUrl")!=null)ret.append("oldYybUrl",oldAppConf.get("yybUrl"));
        if (oldAppConf.get("iosScheme")!=null)ret.append("oldIosScheme",oldAppConf.get("iosScheme"));
        if (oldAppConf.get("androidScheme")!=null)ret.append("oldAndroidScheme",oldAppConf.get("androidScheme"));
        if (oldAppConf.get("iosYyb")!=null)ret.append("oldIosYybSwitch",oldAppConf.get("iosYyb"));
        if (oldAppConf.get("androidYyb")!=null)ret.append("oldAndroidYybSwitch",oldAppConf.get("androidYyb"));
        if (oldAppConf.get("viewName")!=null)ret.append("oldAppname",oldAppConf.get("viewName"));
        if (oldAppConf.get("viewIcon")!=null)ret.append("oldAppIcon",oldAppConf.get("viewIcon"));
        if (oldAppConf.get("viewDetail")!=null)ret.append("oldAppDetail",oldAppConf.get("viewDetail"));
        if (oldAppConf.get("styleId")!=null)ret.append("styleId",oldAppConf.get("styleId"));
        if (oldAppConf.get("backgroundColor")!=null)ret.append("backgroundColor",oldAppConf.get("backgroundColor"));
        if (oldAppConf.get("buttonColor")!=null)ret.append("buttonColor",oldAppConf.get("buttonColor"));
        if (oldAppConf.get("buttonFontColor")!=null)ret.append("buttonFontColor",oldAppConf.get("buttonFontColor"));
        if (oldAppConf.get("nameFontColor")!=null)ret.append("nameFontColor",oldAppConf.get("nameFontColor"));
        if (oldAppConf.get("detailFontColor")!=null)ret.append("detailFontColor",oldAppConf.get("detailFontColor"));
        if (oldAppConf.get("validTime")!=null)ret.append("oldSceneValidTime",oldAppConf.get("validTime"));
        if (oldAppConf.get("ulOpenUrl")!=null)ret.append("ulOpenUrl",oldAppConf.get("ulOpenUrl"));
        if (oldAppConf.get("androidUlSwitch")!=null)ret.append("androidUlSwitch",oldAppConf.get("androidUlSwitch"));
        if (oldAppConf.get("iosUlSwitch")!=null)ret.append("iosUlSwitch",oldAppConf.get("iosUlSwitch"));
        if (oldAppConf.get("iosSourceMap")!=null)ret.append("iosSourceMap",oldAppConf.get("iosSourceMap"));
        if (oldAppConf.get("androidSourceMap")!=null)ret.append("androidSourceMap",oldAppConf.get("androidSourceMap"));
        if (oldAppConf.get("communalKey")!=null)ret.append("oldCertificates",oldAppConf.get("communalKey"));

        return ret;
    }
}
