/*
 * package com.jacliu.test.testValidator;
 * 
 * import javax.validation.GroupSequence; import
 * javax.validation.constraints.AssertTrue; import
 * javax.validation.constraints.Email; import
 * javax.validation.constraints.NotEmpty;
 * 
 * @GroupSequence({DefaultGroup.class,AvailableFlightGroup.class,
 * DestinationFlightGroup.class}) public class DefaultGroup {
 * 
 * @NotEmpty(groups={DestinationFlightGroup.class}) private String name;
 * 
 * @Email(groups={AvailableFlightGroup.class}) private String email;
 * 
 * @AssertTrue private boolean man; }
 */