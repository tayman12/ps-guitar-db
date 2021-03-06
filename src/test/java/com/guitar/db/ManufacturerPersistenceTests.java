package com.guitar.db;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import com.guitar.db.repository.ManufatureJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guitar.db.model.Manufacturer;
import com.guitar.db.repository.ManufacturerRepository;

@ContextConfiguration(locations={"classpath:com/guitar/db/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ManufacturerPersistenceTests {
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private ManufatureJpaRepository manufatureJpaRepository;

	@Test
	public void testGetManufacturersFoundedBeforeDate() throws Exception {
		List<Manufacturer> mans = manufacturerRepository.getManufacturersFoundedBeforeDate(new Date());
		assertEquals(2, mans.size());
	}

	@Test
	public void testGetManufactureByName() throws Exception {
		Manufacturer m = manufacturerRepository.getManufacturerByName("Fender");
		assertEquals("Fender Musical Instruments Corporation", m.getName());
	}

	@Test
	public void testGetManufacturersThatSellModelsOfType() throws Exception {
		List<Manufacturer> mans = manufacturerRepository.getManufacturersThatSellModelsOfType("Semi-Hollow Body Electric");
		assertEquals(1, mans.size());
	}

	@Test
	public void testTrue() throws Exception {
		List<Manufacturer> mans = manufatureJpaRepository.findByActiveTrue();
		assertEquals("Fender Musical Instruments Corporation", mans.get(0).getName());
	}

	@Test
	public void testFalse() throws Exception {
		List<Manufacturer> mans = manufatureJpaRepository.findByActiveFalse();
		assertEquals("Gibson Guitar Corporation", mans.get(0).getName());
	}
}
