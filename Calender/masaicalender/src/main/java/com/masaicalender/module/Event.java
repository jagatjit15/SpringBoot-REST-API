package com.masaicalender.module;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;import javax.persistence.Id;import javax.validation.constraints.FutureOrPresent;import javax.validation.constraints.NotBlank;import javax.validation.constraints.NotEmpty;import com.fasterxml.jackson.annotation.JsonIgnore;import java.time.LocalDate;@Data@NoArgsConstructor@AllArgsConstructor@Entitypublic class Event {    @Id    @GeneratedValue(strategy = GenerationType.AUTO)    @JsonIgnore    private Integer event_Id;    @NotBlank    @NotEmpty(message = "Should not empty")    private String eventName;    @FutureOrPresent    private LocalDate eventStartDate;    @FutureOrPresent    private LocalDate eventEndDate;        private String eventStartTime;       private String eventEndTime;}