package utils;

import dao.TeacherDAO;
import tables.Teacher;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TeacherConverter implements Converter{
    @EJB
    TeacherDAO teacherDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return teacherDAO.findAll().stream().filter(t->s.equals(t.toString())).findFirst().orElse(new Teacher());
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
