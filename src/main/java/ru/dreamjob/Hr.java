package ru.dreamjob;

import java.util.Objects;

public class Hr {

    private String companyName;

    public Hr(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean inviteCandidate() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hr hr = (Hr) o;
        return Objects.equals(companyName, hr.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName);
    }

    @Override
    public String toString() {
        return "Hr{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
