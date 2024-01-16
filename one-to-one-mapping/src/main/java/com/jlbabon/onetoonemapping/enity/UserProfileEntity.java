package com.jlbabon.onetoonemapping.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlbabon.onetoonemapping.constants.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profiles")
@Entity
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileId;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private LocalDateTime birthday;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "userProfile")
    @JsonIgnore
    private UserEntity user;
}
