package com.fourlands.revenge;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import java.util.List;

public class HibernateReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

    private static final String TARGET_PACKAGE = "com.fourlands.persistence.entity";

    public HibernateReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
        // Convertir nombres de tabla en snake_case a CamelCase y añadir 'Entity'
        String tableName = tableIdentifier.getName();
        return TARGET_PACKAGE + "." + toCamelCase(tableName) + "Entity";
    }

    @Override
    public String columnToPropertyName(TableIdentifier table, String column) {
        // Convertir nombres de columna en snake_case a camelCase
        return toCamelCase(column);
    }

    @Override
    public String foreignKeyToEntityName(String keyname, TableIdentifier fromTable, List<?> fromColumns, TableIdentifier referencedTable,
                                         List<?> referencedColumns, boolean uniqueReference) {
        // Personalización para el nombre de la entidad basado en la clave foránea
        return "FK" + super.foreignKeyToEntityName(keyname, fromTable, fromColumns, referencedTable, referencedColumns, uniqueReference);
    }


    private String toCamelCase(String input) {
        StringBuilder builder = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : input.toCharArray()) {
            if (c == '_') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                builder.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                builder.append(Character.toLowerCase(c));
            }
        }
        return builder.toString();
    }
}