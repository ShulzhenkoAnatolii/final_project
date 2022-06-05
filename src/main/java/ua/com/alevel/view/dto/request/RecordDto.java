package ua.com.alevel.view.dto.request;

import lombok.Data;

@Data
public class RecordDto {
    private Long doctorId;
    private Long vaccinationCenterId;
    private Long patientId;
    private Long vaccineId;
    private String selectedTime;
    private String selectedDate;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
}
