package com.rasterbrain.acl.services;

import org.ksoap2.serialization.SoapObject;

import com.rasterbrain.acl.Constants;

public class UserService {
	String SOAP_ACTION = "";

	public String checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		SOAP_ACTION = Constants.NAME_SPACE + "login";
		SoapObject object = new SoapObject(Constants.NAME_SPACE, "loginCheck");
		object.addProperty("username", username);
		object.addProperty("password", password);
		String rsp = upload(object);
		return rsp;
	}

	private String upload(SoapObject object) {
		// TODO Auto-generated method stub
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(object);
		HttpTransportSE se = new HttpTransportSE(Constants.URL);
		try {
			se.call(SOAP_ACTION, envelope);
			SoapPrimitive primitive = (SoapPrimitive) envelope.getResponse();
			return primitive.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
