package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    private long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntryToCreate) {
        Long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntryToCreate.getProjectId(),
                timeEntryToCreate.getUserId(),
                timeEntryToCreate.getDate(),
                timeEntryToCreate.getHours()
        );

        timeEntries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntryToUpdate) {
        if (find(id) == null) return null;

        TimeEntry updatedTimeEntry = new TimeEntry(
                id,
                timeEntryToUpdate.getProjectId(),
                timeEntryToUpdate.getUserId(),
                timeEntryToUpdate.getDate(),
                timeEntryToUpdate.getHours()
        );

        timeEntries.replace(id, updatedTimeEntry);
        return updatedTimeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }
}
