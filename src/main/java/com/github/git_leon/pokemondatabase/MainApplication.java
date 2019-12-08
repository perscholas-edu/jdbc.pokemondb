package com.github.git_leon.pokemondatabase;

import com.github.git_leon.pokemondatabase.model.Pokemon;
import com.github.git_leon.utils.jdbc.database.Database;
import com.github.git_leon.utils.jdbc.database.DatabaseInterface;
import com.github.git_leon.utils.jdbc.database.DatabaseTable;
import com.github.git_leon.utils.jdbc.database.DatabaseTableStatementGenerator;
import com.github.git_leon.utils.jdbc.executor.StatementExecutorInterface;

/**
 * Created by leon on 3/14/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        DatabaseInterface database = Database.UAT;
        database.drop();
        database.create();
        database.use();

        Pokemon pokemonToAddToDatabase = new Pokemon(52L , "Pikachu", 9, null);
        Class<? extends Pokemon> classToPersist = pokemonToAddToDatabase.getClass();
        DatabaseTableStatementGenerator statementGenerator = new DatabaseTableStatementGenerator(database, classToPersist);
        DatabaseTable table = database.getTable(classToPersist.getSimpleName());

        StatementExecutorInterface statementExecutor = database.getStatementExecutor();
        String createStatement = statementGenerator.getCreateStatement();
        String insertionStatement = statementGenerator.getInsertionStatement(pokemonToAddToDatabase);
        String insertionStatementHardCoded = "INSERT INTO UAT.pokemon (id, name, primaryType, secondaryType) VALUES (1, 'Smeargle', 1, null);";

        statementExecutor.executeAndCommit(createStatement);
        statementExecutor.executeAndCommit(insertionStatementHardCoded);
//        statementExecutor.executeAndCommit(insertionStatement);

        System.out.println(table.all());
    }
}
