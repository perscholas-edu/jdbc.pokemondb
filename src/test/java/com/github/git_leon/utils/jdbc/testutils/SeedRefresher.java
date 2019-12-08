package com.github.git_leon.utils.jdbc.testutils;

import com.github.git_leon.utils.jdbc.database.Database;
import com.github.git_leon.utils.jdbc.database.DatabaseInterface;

public class SeedRefresher {
    @Deprecated
    public static void refreshPokemonDatabase() {
        refresh(Database.POKEMON);
    }

    public static void refresh() {
        refresh(Database.UAT);
    }

    public static void refresh(DatabaseInterface database) {
        database.drop();
        database.create();
        database.use();
    }
}