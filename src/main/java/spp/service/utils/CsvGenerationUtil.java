/*
package spp.service.utils;


import au.com.bytecode.opencsv.CSVWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.*;

public class CsvGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInCSV() throws IOException {
        String[] fileHeader = {"N", "Employer", "Title", "Summary", "Salary", "Skills", "Experience"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        VacancyDao vacancyDao = new VacancyDao();
        List<Vacancy> vacancyList = vacancyDao.getAllVacancies();
        for (int i = 0; i < vacancyList.size(); i++) {
            Vacancy vacancy = vacancyList.get(i);
            vacanciesInString.add(new String[]{
                    Integer.toString(i + 1),
                    vacancy.getEmployer().getEmail(),
                    vacancy.getTitle(),
                    vacancy.getSummary(),
                    vacancy.getSalary(),
                    vacancy.getRequiredSkills(),
                    vacancy.getRequiredExperience()});
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateUsersInCSV() throws IOException {
        String[] fileHeader = {"N", "E-mail", "User type", "Name", "Surname", "About", "Contact info", "Is Admin"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("cp1251")), ',');
        writer.writeNext(fileHeader);
        List<String[]> usersInString = new ArrayList<>();
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            usersInString.add(new String[]{
                    Integer.toString(i + 1),
                    user.getEmail(),
                    user.getUserType().toString(),
                    user.getName(),
                    user.getSurname(),
                    user.getAbout(),
                    user.getContactInfo(),
                    Boolean.toString(user.getIsAdmin())
            });
        }

        writer.writeAll(usersInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateResumesInCSV() throws IOException {
        String[] fileHeader = {"N", "Employee", "Summary", "Skills", "Education", "Experience"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("cp1251")), ',');
        writer.writeNext(fileHeader);
        List<String[]> resumesInString = new ArrayList<>();
        ResumeDao resumeDao = new ResumeDao();
        List<Resume> resumeList = resumeDao.getAllResumes();
        for (int i = 0; i < resumeList.size(); i++) {
            Resume resume = resumeList.get(i);
            Set<Education> educationList = resume.getEducations();
            String newTempEducation = "";
            for (Education temp : educationList) {
                newTempEducation = temp.getUniversity() + "\n" + temp.getSpecialty();
            }
            Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
            String newTempExperience = "";
            for (WorkExperience temp : workExperiencesSet) {
                newTempExperience = temp.getCompanyName() + "\n" + temp.getDescription();
            }
            resumesInString.add(new String[]{
                    Integer.toString(i + 1),
                    resume.getEmployee().getEmail(),
                    resume.getSummary(),
                    resume.getSkills(),
                    newTempEducation,
                    newTempExperience});
        }

        writer.writeAll(resumesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateResumeInCSV(int resumeId) throws IOException {
        String[] fileHeader = {"Employee", "Summary", "Skills", "Education", "Experience", "Description", "Interests"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("cp1251")), ',');
        writer.writeNext(fileHeader);
        List<String[]> resumeInString = new ArrayList<>();
        ResumeDao resumeDao = new ResumeDao();

        Resume resume = Optional.ofNullable(resumeDao.getResume(resumeId))
                .orElse(new Resume());
        Set<Education> educationList = Optional.ofNullable(resume)
                .map(Resume::getEducations)
                .orElse(Collections.emptySet());
        String newTempEducation = "";
        for (Education temp : educationList) {
            newTempEducation = temp.getUniversity() + "\n" + temp.getSpecialty();
        }
        Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
        String newTempExperience = "";
        for (WorkExperience temp : workExperiencesSet) {
            newTempExperience = temp.getCompanyName() + "\n" + temp.getDescription();
        }
        String[] tempArray = {
                Optional.ofNullable(resume.getEmployee())
                        .map(User::getEmail)
                        .orElse(null),
                resume.getSummary(),
                resume.getSkills(),
                newTempEducation,
                newTempExperience,
                resume.getDescription(),
                resume.getInterests()};
        resumeInString.add(tempArray);

        writer.writeAll(resumeInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateVacancyInCSV(int vacancyId) throws IOException {
        String[] fileHeader = {"Employeer", "Title", "Summary", "Salary", "Experience", "Description", "Skills"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("cp1251")), ',');
        writer.writeNext(fileHeader);
        List<String[]> vacancyInString = new ArrayList<>();
        VacancyDao vacancyDao = new VacancyDao();

        Vacancy vacancy = Optional.ofNullable(vacancyDao.getVacancy(vacancyId))
                .orElse(new Vacancy());

        String[] tempArray = {
                Optional.ofNullable(vacancy.getEmployer())
                        .map(User::getEmail)
                        .orElse(null),
                vacancy.getTitle(),
                vacancy.getSummary(),
                vacancy.getSalary(),
                vacancy.getRequiredExperience(),
                vacancy.getDescription(),
                vacancy.getRequiredSkills()};
        vacancyInString.add(tempArray);

        writer.writeAll(vacancyInString);
        writer.close();
        return stream;
    }

}
*/
