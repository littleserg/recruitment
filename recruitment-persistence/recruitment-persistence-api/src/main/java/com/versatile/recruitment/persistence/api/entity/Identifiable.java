package com.versatile.recruitment.persistence.api.entity;

import java.io.Serializable;

/**
 * Implemented by the objects/entities, that have long identifier.
 *
 * @author Sergey Netesanyi
 * @version 1.0
 */
public interface Identifiable extends Serializable {

    /**
     * Gets identifier.
     *
     * @return Identifier value.
     */
    Long getId();
}
