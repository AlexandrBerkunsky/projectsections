package beans;

import dao.TeacherDAO;
import tables.Teacher;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Named
@SessionScoped
public class TeacherBean implements Serializable {
    @EJB
    TeacherDAO teacherDAO;

    private boolean edit = false;

    private boolean teacheradd = false;

    public boolean isTeacheradd() {
        return teacheradd;
    }

    public boolean isEdit() {
        return edit;
    }

    @Inject
    CommonUtils util;

    private Teacher teacher = new Teacher();

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Teacher> getTeachers() {
        return teacherDAO.findAll();
    }

    public void showadd() {
        teacheradd = true;
        edit = false;

        util.redirectWithGet();
    }

    public void add() {
        teacherDAO.add(teacher);
        teacher = new Teacher();
        teacheradd = false;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.teacher = new Teacher();
        edit = false;

        util.redirectWithGet();
    }

    public void delete(int id) {
        teacherDAO.delete(id);

        util.redirectWithGet();
    }

    public void editTeacher(Teacher teacher) {
        teacheradd = false;
        this.teacher = teacher;
        edit = true;

        util.redirectWithGet();
    }

    public void saveEdit() {
        teacherDAO.save(teacher);
        this.teacher = new Teacher();
        edit = false;

        util.redirectWithGet();
    }

    public Map<String, Integer> getTeachersMap(){
        return teacherDAO.findAll().stream().collect(Collectors.toMap(Teacher::toString, Teacher::getId, (a, b) -> b, LinkedHashMap::new));
    }
}
