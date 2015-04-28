package example;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mdev on 4/17/15.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "roundtable_development")
public class UsersEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String email;
    private String encryptedPassword;
    private String resetPasswordToken;
    private Timestamp resetPasswordSentAt;
    private Timestamp rememberCreatedAt;
    private int signInCount;
    private Timestamp currentSignInAt;
    private Timestamp lastSignInAt;
    private String currentSignInIp;
    private String lastSignInIp;
    private String confirmationToken;
    private Timestamp confirmedAt;
    private Timestamp confirmationSentAt;
    private String unconfirmedEmail;
    private int failedAttempts;
    private String unlockToken;
    private Timestamp lockedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean isAdmin;
    private Boolean isFeatured;
    private String bio;
    private String slug;
    private Timestamp lastSeenAt;
    private String website;
    private String homeCity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "encrypted_password")
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Basic
    @Column(name = "reset_password_token")
    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    @Basic
    @Column(name = "reset_password_sent_at")
    public Timestamp getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(Timestamp resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    @Basic
    @Column(name = "remember_created_at")
    public Timestamp getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public void setRememberCreatedAt(Timestamp rememberCreatedAt) {
        this.rememberCreatedAt = rememberCreatedAt;
    }

    @Basic
    @Column(name = "sign_in_count")
    public int getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(int signInCount) {
        this.signInCount = signInCount;
    }

    @Basic
    @Column(name = "current_sign_in_at")
    public Timestamp getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Timestamp currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    @Basic
    @Column(name = "last_sign_in_at")
    public Timestamp getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Timestamp lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    @Basic
    @Column(name = "current_sign_in_ip")
    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(String currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    @Basic
    @Column(name = "last_sign_in_ip")
    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
    }

    @Basic
    @Column(name = "confirmation_token")
    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    @Basic
    @Column(name = "confirmed_at")
    public Timestamp getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Timestamp confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    @Basic
    @Column(name = "confirmation_sent_at")
    public Timestamp getConfirmationSentAt() {
        return confirmationSentAt;
    }

    public void setConfirmationSentAt(Timestamp confirmationSentAt) {
        this.confirmationSentAt = confirmationSentAt;
    }

    @Basic
    @Column(name = "unconfirmed_email")
    public String getUnconfirmedEmail() {
        return unconfirmedEmail;
    }

    public void setUnconfirmedEmail(String unconfirmedEmail) {
        this.unconfirmedEmail = unconfirmedEmail;
    }

    @Basic
    @Column(name = "failed_attempts")
    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    @Basic
    @Column(name = "unlock_token")
    public String getUnlockToken() {
        return unlockToken;
    }

    public void setUnlockToken(String unlockToken) {
        this.unlockToken = unlockToken;
    }

    @Basic
    @Column(name = "locked_at")
    public Timestamp getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(Timestamp lockedAt) {
        this.lockedAt = lockedAt;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "is_admin")
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Basic
    @Column(name = "is_featured")
    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    @Basic
    @Column(name = "bio")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Basic
    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "last_seen_at")
    public Timestamp getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(Timestamp lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "home_city")
    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (failedAttempts != that.failedAttempts) return false;
        if (id != that.id) return false;
        if (signInCount != that.signInCount) return false;
        if (bio != null ? !bio.equals(that.bio) : that.bio != null) return false;
        if (confirmationSentAt != null ? !confirmationSentAt.equals(that.confirmationSentAt) : that.confirmationSentAt != null)
            return false;
        if (confirmationToken != null ? !confirmationToken.equals(that.confirmationToken) : that.confirmationToken != null)
            return false;
        if (confirmedAt != null ? !confirmedAt.equals(that.confirmedAt) : that.confirmedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (currentSignInAt != null ? !currentSignInAt.equals(that.currentSignInAt) : that.currentSignInAt != null)
            return false;
        if (currentSignInIp != null ? !currentSignInIp.equals(that.currentSignInIp) : that.currentSignInIp != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (encryptedPassword != null ? !encryptedPassword.equals(that.encryptedPassword) : that.encryptedPassword != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (homeCity != null ? !homeCity.equals(that.homeCity) : that.homeCity != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;
        if (isFeatured != null ? !isFeatured.equals(that.isFeatured) : that.isFeatured != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastSeenAt != null ? !lastSeenAt.equals(that.lastSeenAt) : that.lastSeenAt != null) return false;
        if (lastSignInAt != null ? !lastSignInAt.equals(that.lastSignInAt) : that.lastSignInAt != null) return false;
        if (lastSignInIp != null ? !lastSignInIp.equals(that.lastSignInIp) : that.lastSignInIp != null) return false;
        if (lockedAt != null ? !lockedAt.equals(that.lockedAt) : that.lockedAt != null) return false;
        if (rememberCreatedAt != null ? !rememberCreatedAt.equals(that.rememberCreatedAt) : that.rememberCreatedAt != null)
            return false;
        if (resetPasswordSentAt != null ? !resetPasswordSentAt.equals(that.resetPasswordSentAt) : that.resetPasswordSentAt != null)
            return false;
        if (resetPasswordToken != null ? !resetPasswordToken.equals(that.resetPasswordToken) : that.resetPasswordToken != null)
            return false;
        if (slug != null ? !slug.equals(that.slug) : that.slug != null) return false;
        if (unconfirmedEmail != null ? !unconfirmedEmail.equals(that.unconfirmedEmail) : that.unconfirmedEmail != null)
            return false;
        if (unlockToken != null ? !unlockToken.equals(that.unlockToken) : that.unlockToken != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (encryptedPassword != null ? encryptedPassword.hashCode() : 0);
        result = 31 * result + (resetPasswordToken != null ? resetPasswordToken.hashCode() : 0);
        result = 31 * result + (resetPasswordSentAt != null ? resetPasswordSentAt.hashCode() : 0);
        result = 31 * result + (rememberCreatedAt != null ? rememberCreatedAt.hashCode() : 0);
        result = 31 * result + signInCount;
        result = 31 * result + (currentSignInAt != null ? currentSignInAt.hashCode() : 0);
        result = 31 * result + (lastSignInAt != null ? lastSignInAt.hashCode() : 0);
        result = 31 * result + (currentSignInIp != null ? currentSignInIp.hashCode() : 0);
        result = 31 * result + (lastSignInIp != null ? lastSignInIp.hashCode() : 0);
        result = 31 * result + (confirmationToken != null ? confirmationToken.hashCode() : 0);
        result = 31 * result + (confirmedAt != null ? confirmedAt.hashCode() : 0);
        result = 31 * result + (confirmationSentAt != null ? confirmationSentAt.hashCode() : 0);
        result = 31 * result + (unconfirmedEmail != null ? unconfirmedEmail.hashCode() : 0);
        result = 31 * result + failedAttempts;
        result = 31 * result + (unlockToken != null ? unlockToken.hashCode() : 0);
        result = 31 * result + (lockedAt != null ? lockedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        result = 31 * result + (isFeatured != null ? isFeatured.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (lastSeenAt != null ? lastSeenAt.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (homeCity != null ? homeCity.hashCode() : 0);
        return result;
    }
}
