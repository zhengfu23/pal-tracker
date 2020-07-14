package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntryToCreate);

    List<TimeEntry> list();

    TimeEntry find(long id);

    TimeEntry update(long id, TimeEntry timeEntryToUpdate);

    void delete(long id);
}
