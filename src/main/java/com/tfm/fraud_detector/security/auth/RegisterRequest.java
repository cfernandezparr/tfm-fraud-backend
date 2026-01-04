package com.tfm.fraud_detector.security.auth;

import com.tfm.fraud_detector.security.Role;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
