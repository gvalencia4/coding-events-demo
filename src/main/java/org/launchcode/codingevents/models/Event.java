package org.launchcode.codingevents.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    private EventType type;

    @NotBlank(message = "Location must be specified")
    @NotNull(message = "Location must not be null")
    private String location;

    @NotNull(message = "registrationRequired must not be null")
    private boolean registrationRequired;

    @Positive(message="Event size must be larger than 0")
    private int attendees;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Select a start date")
    private Date startDate;

    public Event(String name,
                 String description,
                 String contactEmail,
                 EventType event,
                 String location,
                 boolean registrationRequired,
                 int attendees,
                 Date startDate) {

        this();
        this.name = name;
        this.location = location;
        this.description = description;
        this.contactEmail = contactEmail;
        this.registrationRequired = registrationRequired;
        this.type = type;
        this.attendees = attendees;
        this.startDate = startDate;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
