/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.hks.repostory;

import org.springframework.data.repository.CrudRepository;

import mksgroup.hks.entity.HksItems;

/**
 * @author ThachLN
 *
 */
public interface ItemRepository extends CrudRepository<HksItems, Integer> {

}
