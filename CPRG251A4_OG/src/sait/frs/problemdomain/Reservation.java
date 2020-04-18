package sait.frs.problemdomain;

import java.util.*;
import sait.frs.exception.*;

public final class Reservation
{
    public static final int RECORD_SIZE = 171;
    private String code;
    private Flights flight;
    private String name;
    private String citizenship;
    private boolean active;
    
    public Reservation(final Flights flight, final String name, final String citizenship) throws NullFlightException, InvalidNameException, InvalidCitizenshipException {
        this.code = generateCodeFromFlight(flight);
        this.setFlight(flight);
        this.setName(name);
        this.setCitizenship(citizenship);
        this.active = true;
    }
    
    public Reservation(final String code, final Flights flight, final String name, final String citizenship, final boolean active) throws NullFlightException, InvalidNameException, InvalidCitizenshipException {
        this.code = code;
        this.setFlight(flight);
        this.setName(name);
        this.setCitizenship(citizenship);
        this.active = active;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public Flights getFlight() {
        return this.flight;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setFlight(final Flights flight) throws NullFlightException {
        if (flight == null) {
            throw new NullFlightException();
        }
        this.flight = flight;
    }
    
    public void setName(final String name) throws InvalidNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException();
        }
        this.name = name;
    }
    
    public String getCitizenship() {
        return this.citizenship;
    }
    
    public void setCitizenship(final String citizenship) throws InvalidCitizenshipException {
        if (citizenship == null || citizenship.isEmpty()) {
            throw new InvalidCitizenshipException();
        }
        this.citizenship = citizenship;
    }
    
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(final boolean active) {
        this.active = active;
    }
    
    private static String generateCodeFromFlight(final Flights flight) {
        final char letter = flight.isDomestic() ? 'D' : 'I';
        final Random rand = new Random();
        return String.format("%c%d", letter, rand.nextInt(9999) + 1000);
    }
    
    @Override
    public String toString() {
        return this.getCode();
    }
}