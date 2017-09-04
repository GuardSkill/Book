package cn.guardskill.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import cn.guardskill.orm.HostInfo;
import cn.guardskill.orm.RedisMsg;
import redis.clients.jedis.Jedis;

public class RedisAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<HostInfo> hostinfos = new ArrayList<HostInfo>();
	private String channel;
	public RedisMsg msg;

	public String exeMute() throws Exception {
		Jedis conn = new Jedis("guardskill.cn", 6339);
		try {
			// :,
			// abortConnect=false,password=S1042h28,ConnectTimeout=3,connectRetry=3
			conn.auth("S1042h28");
			conn.connect();
			msg.setInterval(3);
			msg.setVolume(0.0);
			JSONObject obj = new JSONObject(msg);
			//String jsonMsg=JSONObject.fromObject(msg).toString();
			//JSONObject jsonObject = JSONObject.fromObject(msg);
			if(msg.getMode()==2)
			{
				conn.publish("10_104_96_18  10.104.96.18", obj.toString());
				   Thread.sleep(2000);
				return "toShowMute";
			}
			else
			{
				conn.publish(channel, obj.toString());
			}
			addActionMessage("设置成功！请Azure刷新");
			return SUCCESS;
		} 
		catch (Exception e) {
			addActionMessage("获取失败信息" + e.toString());
			return NONE;
		} finally {
			conn.close();
		}
	}

	public String showMute() throws Exception {
		Jedis conn = new Jedis("guardskill.cn", 6339);
		// :,
		// abortConnect=false,password=S1042h28,ConnectTimeout=3,connectRetry=3
		conn.auth("S1042h28");
		conn.connect();
		try {
			Map<String, String> map = conn.hgetAll("HOST_DATA");
			for (Map.Entry<String, String> entry : map.entrySet()) {
				HostInfo h = new HostInfo();
				h.setIp(entry.getKey());
				entry.getValue();
				h.setTime(entry.getValue());
				hostinfos.add(h);
			}
			return SUCCESS;
		} catch (Exception e) {
			addActionMessage("获取失败信息" + e.toString());
			return NONE;
		} finally {
			conn.close();
		}
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public RedisMsg getMsg() {
		return msg;
	}

	public void setMsg(RedisMsg msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<HostInfo> getHostinfos() {
		return hostinfos;
	}

	public void setHostinfos(List<HostInfo> hostinfos) {
		this.hostinfos = hostinfos;
	}

}
