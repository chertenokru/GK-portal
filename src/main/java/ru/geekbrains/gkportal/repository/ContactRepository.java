package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    Contact findByFirstNameAndLastNameAndMiddleName
            (
                    String firstName,
                    String lastName,
                    String middleName
            );

    List<Contact> findAllByQuestionnaireContactConfirm_QuestionnaireUuid(String questionnaireId);
}
