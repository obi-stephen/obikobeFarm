package com.ofl.backendservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author stephen.obi
 */
@Builder
@Data
@Entity
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String email;
    @Size(max = 50)
    @Column(name = "PHONE_NO", length = 50)
    private String phoneNo;
    @Column(name = "PHONE_NO_CONFIRMED")
    private Integer phoneNoConfirmed;
    @Size(max = 50)
    @Column(name = "ALT_TWO_FA_PHONE_NO", length = 50)
    private String altTwoFaPhoneNo;
    @Size(max = 255)
    @Column(length = 255)
    private String firstname;
    @Size(max = 255)
    @Column(length = 255)
    private String lastname;
    @Column(name = "LAST_LOGIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Size(max = 255)
    @Column(name = "LOGIN_IP", length = 255)
    private String loginIp;
    @Size(max = 255)
    @Column(length = 255)
    private String cypher;
    @Size(max = 50)
    @Column(name = "CYPHER_SALT", length = 50)
    private String cypherSalt;
    @Column(name = "LAST_CYPHER_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCypherChange;
    @Column(name = "CYPHER_RESET")
    private Integer cypherReset;
    @Size(max = 255)
    @Column(name = "CYPHER_RESET_STR", length = 255)
    private String cypherResetStr;
    @Column(name = "CYPHER_RESET_EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cypherResetExpiryDate;
    @Column(name = "FORCE_CYPHER_CHANGE")
    private Integer forceCypherChange;
    @Column(name = "LOGIN_ATTEMPTS")
    private Integer loginAttempts;
    @Column(name = "TWO_FA_ENABLED_AUTH")
    private Integer twoFaEnabledAuth;
    @Column(name = "TWO_FA_TYPE")
    private Integer twoFaType;
    @Size(max = 100)
    @Column(name = "TWO_FA_SEED", length = 100)
    private String twoFaSeed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRANSACTION_LIMIT", precision = 19, scale = 2)
    private BigDecimal transactionLimit;
    @Size(max = 255)
    @Column(name = "TRANSACTION_PIN", length = 255)
    private String transactionPin;
    @Column(name = "RESET_TRANSACTION_PIN")
    private Integer resetTransactionPin;
    @Column(name = "USER_LOCKED")
    private Integer userLocked;
    @Column(name = "USER_LOCKED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userLockedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_TYPE", nullable = false)
    private int userType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_LEVEL", nullable = false)
    private int userLevel;
    private Integer status;
    private Integer authorized;
    @Size(max = 255)
    @Column(name = "API_KEY", length = 255)
    private String apiKey;
    @Size(max = 100)
    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 100)
    @Column(name = "LAST_MODIFIED_BY", length = 100)
    private String lastModifiedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    private BigInteger version;

}