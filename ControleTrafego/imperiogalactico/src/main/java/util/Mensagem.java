package util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {

	public static String getMessageBundle(String key) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResourceBundle bundle = ResourceBundle.getBundle(context
					.getApplication().getMessageBundle());

			return bundle.getString(key);

		} catch (RuntimeException e) {
			return null;
		}
	}

	public static void addMensagemErroFacesContext(String key) {
		addMensagemErroFacesContext(key, null);
	}

	public static void addMensagemErroFacesContext(String key, String param) {
		FacesContext context = FacesContext.getCurrentInstance();
		String formattedMessage = null;

		if (param != null) {
			formattedMessage = MessageFormat.format(getMessageBundle(key),
					param);
		} else {
			formattedMessage = getMessageBundle(key);
		}
		if (formattedMessage != null) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, key, formattedMessage));
		}
	}

}
