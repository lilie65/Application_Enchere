package fr.eni.application.enchere.messages;

import java.util.ResourceBundle;

public class LectureMessage {

	
	static
	{
		try
		{
			ResourceBundle rb = ResourceBundle.getBundle("fr.eni.javaee.module4.messages.messages_erreur");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param code
	 * @return
	 */
	public static  String getMessageErreur(int code)
	{
		String message="";
		try
		{
			Object rb = null;
			if(rb!=null)
			{
				message = ((ResourceBundle) rb).getString(String.valueOf(code));
			}
			else
			{
				message="Problème à la lecture du fichier contenant les messages";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Une erreur inconnue est survenue";
		}
		return message;
	}
}
