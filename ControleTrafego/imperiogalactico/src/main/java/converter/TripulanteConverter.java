package converter;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Tripulante;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

@FacesConverter(forClass=Tripulante.class, value="tripulanteConverter")
public class TripulanteConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) { 
		Object ret = null; 
		if (arg1 instanceof PickList) { 
			Object dualList = ((PickList) arg1).getValue(); 
			DualListModel dl = (DualListModel) dualList; 
			for (Iterator iterator = dl.getSource().iterator(); iterator 
					.hasNext();) { 
				Object o = iterator.next(); 
				String name = (new StringBuilder()).append( 
						((Tripulante) o).getName()).toString(); 
				if (arg2.equals(name)) { 
					ret = o; 
					break; 
				} 
			} 

			if (ret == null) { 
				for (Iterator iterator1 = dl.getTarget().iterator(); iterator1 
						.hasNext();) { 
					Object o = iterator1.next(); 
					String name = (new StringBuilder()).append( 
							((Tripulante) o).getName()).toString(); 
					if (arg2.equals(name)) { 
						ret = o; 
						break; 
					} 
				} 

			} 
		} 
		return ret; 
	} 

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) { 
		String str = ""; 
		if (arg2 instanceof Tripulante) 
			str = ((Tripulante) arg2).getName().toString(); 
		return str; 
	} 

}