package android.wxapp.service.elec.request;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.wxapp.service.elec.model.CreatePlanTaskRequest;
import android.wxapp.service.elec.model.CreateTaskRequest;
import android.wxapp.service.elec.model.LoginRequest;
import android.wxapp.service.elec.model.UpdateRequest;
import android.wxapp.service.elec.model.bean.Attachments;
import android.wxapp.service.elec.model.bean.Leader;
import android.wxapp.service.elec.model.bean.Uid;
import android.wxapp.service.elec.model.bean.User;
import android.wxapp.service.request.Contants;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class HttpRequest extends BaseRequest {
	
	/**
	 * 登录请求
	 * @param aliasName
	 * @param identifyCode
	 * @param imsi
	 * @return
	 */
	public JsonObjectRequest getLoginRequest(String aliasName, String identifyCode, String imsi) {
		
		LoginRequest lr = new LoginRequest(aliasName, identifyCode, imsi);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.METHOD_PERSON_LOGIN
				+ Contants.PARAM_NAME + super.gson.toJson(lr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						
					} else {
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
	}
	
	/**
	 * 更新本地数据库请求
	 * @param aliasName
	 * @param identifyCode
	 * @param updateTime
	 * @return
	 */
	public JsonObjectRequest getUpdateRequest(String aliasName, String identifyCode, String updateTime){
		
		UpdateRequest ur = new UpdateRequest(aliasName, identifyCode, updateTime);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.UPDATE
				+ Contants.PARAM_NAME + super.gson.toJson(ur);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						
					} else {
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
	}
	
	
	/*
	 * 创建计划任务请求
	 * 
	 */
	public JsonObjectRequest getCreatePlanTaskRequest(String aliasName, String identifyCode, String weather, String name, String power_cut_range,
			String effect_eara, String  content, ArrayList<User> responsibility_user, String plan_start_time, String plan_end_time, String category,
			String is_publish, String special, ArrayList<Leader> leader, String measures, String domain, String is_power_cut,
			String cut_type, String implement_org, String number,String  remark){
		
		CreatePlanTaskRequest cptr = new CreatePlanTaskRequest(aliasName, identifyCode, weather, name, power_cut_range, 
				effect_eara, content, responsibility_user, plan_start_time, plan_end_time,
				category, is_publish, special, leader, measures, domain, is_power_cut,
				cut_type, implement_org, number, remark);
		
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATEPLANTASK
				+ Contants.PARAM_NAME + super.gson.toJson(cptr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						
					} else {
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
	}
	
	/*
	 * 创建新任务请求
	 */
	public JsonObjectRequest getCreateTaskRequest(String aliasName, String identifyCode, List<Uid> uids, String text, List<Attachments> attachments){
		
		CreateTaskRequest ctr = new CreateTaskRequest(aliasName, identifyCode, uids, text, attachments);
		this.url = Contants.SERVER_URL + Contants.MODEL_NAME + Contants.CREATETASK
				+ Contants.PARAM_NAME + super.gson.toJson(ctr);
		Log.e("URL", this.url);
		return new JsonObjectRequest(this.url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				Log.e("Response", arg0.toString());
				try {
					if (arg0.getString("s").equals(Contants.RESULT_SUCCESS)) {
						
					} else {
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
	}
}
