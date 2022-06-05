package ua.com.alevel.view.dto.request;

import lombok.Data;

@Data
public class PatientDto {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;
    private String sexType;

}
