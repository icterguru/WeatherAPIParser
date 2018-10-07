package parserClasses;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherAPIParser {

	public static final void main(String[] args) throws Exception{

		// Yahoo Developer Network: https://developer.yahoo.com/weather/
		// JSON Formatter: https://jsonformatter.curiousconcept.com/
		// Help: https://wwwDOTudemyDOTcom/the-complete-kotlin-developer-course-java/learn/v4/t/lecture/7817434?start=0

		String apiURL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22New%20York%2C%20NY%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

		String jsonStr = RESTfulAPIOperations.restful_GET_Operation(apiURL);
		System.out.println("jsonStr: "+jsonStr);

		JSONObject jsonObject = new JSONObject(jsonStr);
		JSONObject queryObj = jsonObject.getJSONObject("query");
		System.out.println("JSON query Object: "+queryObj);

		/* 
		 // Alternatively, using net.sf.json.JSONSerializer  .....	
		 JSONObject jsonObject = (JSONObject)JSONSerializer.toJSON(jsonStr);
		 JSONObject queryObj = jsonObject.getJSONObject("query");
		 System.out.println("query Object: "+queryObj);
		 */

		System.out.println("count Numnber: "  + queryObj.getLong("count"));
		System.out.println("created String: " + queryObj.getString("created"));
		System.out.println("lang String: "    + queryObj.getString("lang"));
		//		System.out.println("results Object: "  + queryObj.getString("results"));

		System.out.println("count Numnber: "  + queryObj.getLong("count"));
		System.out.println("created String: " + queryObj.getString("created"));
		System.out.println("lang String: "    + queryObj.getString("lang"));
		//		System.out.println("results Object: "  + queryObj.getString("results"));

		System.out.println("channel Object: "  + queryObj.getJSONObject("results").getJSONObject("channel"));

		System.out.println("units Object: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("units"));

		System.out.println("distance String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("units").getString("distance"));
		System.out.println("pressure String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("units").getString("pressure"));
		System.out.println("speed String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("units").getString("speed"));
		System.out.println("temperature String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("units").getString("temperature"));


		System.out.println("title String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("title"));
		System.out.println("link String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("link"));
		System.out.println("description String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("description"));
		System.out.println("language String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("language"));
		System.out.println("lastBuildDate String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("lastBuildDate"));
		System.out.println("ttl String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getString("ttl"));

		System.out.println("location Object: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("location"));
		System.out.println("city String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("location").getString("city"));
		System.out.println("country String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("location").getString("country"));
		System.out.println("region String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("location").getString("region"));


		System.out.println("item Object: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item"));
		System.out.println("title String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getString("title"));
		System.out.println("lat String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getString("lat"));
		System.out.println("long String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getString("long"));

		System.out.println("condition Object : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition"));
		System.out.println("code String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("code"));
		System.out.println("date String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("date"));
		System.out.println("temp String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("temp"));
		System.out.println("text String : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("text"));

		//			System.out.println("forecast JSONObject : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("forcast"));
		//		{"query":{"count":1,"created":"2018-10-07T05:14:38Z","lang":"en-US","results":{"channel":{"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - New York, NY, US","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2459115/","description":"Yahoo! Weather for New York, NY, US","language":"en-us","lastBuildDate":"Sun, 07 Oct 2018 01:14 AM EDT","ttl":"60","location":{"city":"New York","country":"United States","region":" NY"},"wind":{"chill":"66","direction":"205","speed":"14"},"atmosphere":{"humidity":"93","pressure":"1020.0","rising":"0","visibility":"12.5"},"astronomy":{"sunrise":"6:58 am","sunset":"6:29 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for New York, NY, US at 12:00 AM EDT","lat":"40.71455","long":"-74.007118","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2459115/","pubDate":"Sun, 07 Oct 2018 12:00 AM EDT","condition":{"code":"27","date":"Sun, 07 Oct 2018 12:00 AM EDT","temp":"67","text":"Mostly Cloudy"},"forecast":[{"code":"30","date":"07 Oct 2018","day":"Sun","high":"81","low":"67","text":"Partly Cloudy"},{"code":"28","date":"08 Oct 2018","day":"Mon","high":"72","low":"65","text":"Mostly Cloudy"},{"code":"28","date":"09 Oct 2018","day":"Tue","high":"75","low":"65","text":"Mostly Cloudy"},{"code":"47","date":"10 Oct 2018","day":"Wed","high":"78","low":"67","text":"Scattered Thunderstorms"},{"code":"47","date":"11 Oct 2018","day":"Thu","high":"76","low":"69","text":"Scattered Thunderstorms"},{"code":"47","date":"12 Oct 2018","day":"Fri","high":"68","low":"58","text":"Scattered Thunderstorms"},{"code":"30","date":"13 Oct 2018","day":"Sat","high":"59","low":"52","text":"Partly Cloudy"},{"code":"30","date":"14 Oct 2018","day":"Sun","high":"58","low":"49","text":"Partly Cloudy"},{"code":"30","date":"15 Oct 2018","day":"Mon","high":"63","low":"55","text":"Partly Cloudy"},{"code":"30","date":"16 Oct 2018","day":"Tue","high":"62","low":"54","text":"Partly Cloudy"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/27.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Mostly Cloudy\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Sun - Partly Cloudy. High: 81Low: 67\n<BR /> Mon - Mostly Cloudy. High: 72Low: 65\n<BR /> Tue - Mostly Cloudy. High: 75Low: 65\n<BR /> Wed - Scattered Thunderstorms. High: 78Low: 67\n<BR /> Thu - Scattered Thunderstorms. High: 76Low: 69\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2459115/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}}}}

		System.out.println("forecast JSONArray : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast"));


		System.out.println("forecast JSONArray size : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").length());

		System.out.println("forecast JSONArray class : "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getClass());


		JSONArray forcastJSONArray = queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast");


		for (Object ja: forcastJSONArray){
			System.out.println(ja);
		}


		for(int i = 0; i < forcastJSONArray.length();i++) {
			JSONObject forcastJSONObject = forcastJSONArray.getJSONObject(i);
			System.out.println(forcastJSONObject);

			for(Iterator it = forcastJSONObject.keys(); it.hasNext(); ) {
				String key = (String)it.next();
				System.out.println(key + ":" + forcastJSONObject.get(key));
			}
			System.out.println("\n----------------");

		}

		/*	
			for (Object ja: jSONArray){
				System.out.println(ja);
				faalist.add(ja);
			}
			System.out.println("Alternatively.....");

			for (int i = 0; i <jSONArray.size(); i++){
				System.out.println(jSONArray.getString(i));

			}
		 */


		JSONObject forcastJSONObject1 = forcastJSONArray.getJSONObject(0);

		System.out.println("forcastJSONObject1: " + forcastJSONObject1);

		System.out.println("forcastJSONObject[0]'s code String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("code"));
		System.out.println("forcastJSONObject[0]'s date String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("date"));
		System.out.println("forcastJSONObject[0]'s day String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("day"));
		System.out.println("forcastJSONObject[0]'s high String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("high"));
		System.out.println("forcastJSONObject[0]'s low String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("low"));
		System.out.println("forcastJSONObject[0]'s text String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(0).getString("text"));
		System.out.println();
		System.out.println("forcastJSONObject[1]'s code String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("code"));
		System.out.println("forcastJSONObject[1]'s date String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("date"));
		System.out.println("forcastJSONObject[1]'s day String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("day"));
		System.out.println("forcastJSONObject[1]'s high String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("high"));
		System.out.println("forcastJSONObject[1]'s low String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("low"));
		System.out.println("forcastJSONObject[1]'s text String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(1).getString("text"));
		System.out.println();
		System.out.println("forcastJSONObject[2]'s code String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("code"));
		System.out.println("forcastJSONObject[2]'s date String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("date"));
		System.out.println("forcastJSONObject[2]'s day String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("day"));
		System.out.println("forcastJSONObject[2]'s high String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("high"));
		System.out.println("forcastJSONObject[2]'s low String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("low"));
		System.out.println("forcastJSONObject[2]'s text String: "  + queryObj.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast").getJSONObject(2).getString("text"));




	}
}