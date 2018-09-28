package src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.base.Result;
import src.base.ResultCache;
import src.dao.StudentDAO;
import src.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    // encode
    public String encodePassword(String origin_password) {
        return passwordEncoder.encode(origin_password);
    }

    // Boolean
    public Boolean emailExist(String email) {
        return studentDAO.checkMailExisted(email) != 0;
    }

    public Boolean passwordRight(String sid, String input_password) {
        String encoded = studentDAO.getEncodedPassword(sid);
        if (encoded == null || encoded.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(input_password, encoded);
    }

    // -------------------
    public Result updatePassword(String email, String newPass) {
        try {
            studentDAO.updatePassword(email, encodePassword(newPass));
            return ResultCache.OK;
        } catch (Exception e) {
            return ResultCache.DATABASE_ERROR;
        }
    }

    public Result getStudentById(String id) {
        try {
            return ResultCache.getDataOk(studentDAO.getStudentById(id));
        } catch (Exception e) {
            return ResultCache.DATABASE_ERROR;
        }
    }

    public Result insertStudent(Student vo)   {
        try {
            studentDAO.insertStudent(vo);
            return ResultCache.OK;
        } catch (Exception e) {
            return ResultCache.DATABASE_ERROR;
        }
    }





    public Result updateStudent(Student vo)   {
        studentDAO.updateStudent(vo);
        return ResultCache.OK;
    }

    @Transactional
    public Result deleteStudents(Set<String> ids)   {
        for (String id: ids) {
            studentDAO.deleteStudent(id);
        }
        return ResultCache.OK;
    }

    public Result getStudentSplit(Integer page, Integer rows) {
        return ResultCache.getDataOk(studentDAO.getAllSplit(page, rows));
    }

    public Result getAllCount() {
        return ResultCache.getDataOk(studentDAO.getCount());
    }

}
