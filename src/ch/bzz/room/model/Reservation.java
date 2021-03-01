package ch.bzz.room.model;

import java.time.LocalDate;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */
public class Reservation {
    private String name;
    private String surname;
    private String contact;
    private String phoneNr;
    private String mail;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate giveKey;
    private LocalDate receiveKey;
    private boolean willBeCleaned;
    private String wish;
    private String note;

    /**
     * Gets the name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name the value to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname
     *
     * @return value of surname
     */
    public String getSirname() {
        return surname;
    }

    /**
     * Sets the surname
     *
     * @param surname the value to set
     */

    public void setSirname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the contact
     *
     * @return value of contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact
     *
     * @param contact the value to set
     */

    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the phoneNr
     *
     * @return value of phoneNr
     */
    public String getPhoneNr() {
        return phoneNr;
    }

    /**
     * Sets the phoneNr
     *
     * @param phoneNr the value to set
     */

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    /**
     * Gets the mail
     *
     * @return value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the mail
     *
     * @param mail the value to set
     */

    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Gets the startDate
     *
     * @return value of startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the startDate
     *
     * @param startDate the value to set
     */

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the endDate
     *
     * @return value of endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the endDate
     *
     * @param endDate the value to set
     */

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the giveKey
     *
     * @return value of giveKey
     */
    public LocalDate getGiveKey() {
        return giveKey;
    }

    /**
     * Sets the giveKey
     *
     * @param giveKey the value to set
     */

    public void setGiveKey(LocalDate giveKey) {
        this.giveKey = giveKey;
    }

    /**
     * Gets the receiveKey
     *
     * @return value of receiveKey
     */
    public LocalDate getReceiveKey() {
        return receiveKey;
    }

    /**
     * Sets the receiveKey
     *
     * @param receiveKey the value to set
     */

    public void setReceiveKey(LocalDate receiveKey) {
        this.receiveKey = receiveKey;
    }

    /**
     * Gets the willBeCleaned
     *
     * @return value of willBeCleaned
     */
    public boolean isWillBeCleaned() {
        return willBeCleaned;
    }

    /**
     * Sets the willBeCleaned
     *
     * @param willBeCleaned the value to set
     */

    public void setWillBeCleaned(boolean willBeCleaned) {
        this.willBeCleaned = willBeCleaned;
    }

    /**
     * Gets the wish
     *
     * @return value of wish
     */
    public String getWish() {
        return wish;
    }

    /**
     * Sets the wish
     *
     * @param wish the value to set
     */

    public void setWish(String wish) {
        this.wish = wish;
    }

    /**
     * Gets the note
     *
     * @return value of note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note
     *
     * @param note the value to set
     */

    public void setNote(String note) {
        this.note = note;
    }
}
