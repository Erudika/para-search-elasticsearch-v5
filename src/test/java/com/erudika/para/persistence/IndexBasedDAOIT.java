/*
 * Copyright 2013-2018 Erudika. https://erudika.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For issues and patches go to: https://github.com/erudika
 */
package com.erudika.para.persistence;

import com.erudika.para.search.ElasticSearch;
import com.erudika.para.search.ElasticSearchUtils;
import com.erudika.para.search.Search;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * DEPRECATED! 
 * @author Alex Bogdanovski [alex@erudika.com]
 */
@Ignore
public class IndexBasedDAOIT extends DAOTest {

	private static final String ROOT_APP_NAME = "para-test-dao";

	public IndexBasedDAOIT() {
		super(get());
	}

	private static DAO get() {
		DAO dao = new IndexBasedDAO();
		Search search = new ElasticSearch(dao);
		((IndexBasedDAO) dao).setSearch(search);
		return dao;
	}

	@BeforeClass
	public static void setUpClass() {
		System.setProperty("para.env", "embedded");
		System.setProperty("para.app_name", ROOT_APP_NAME);
		System.setProperty("para.cluster_name", "test");

		ElasticSearchUtils.createIndex(ROOT_APP_NAME);
		ElasticSearchUtils.createIndex(appid1);
		ElasticSearchUtils.createIndex(appid2);
		ElasticSearchUtils.createIndex(appid3);
	}

	@AfterClass
	public static void tearDownClass() {
		ElasticSearchUtils.deleteIndex(ROOT_APP_NAME);
		ElasticSearchUtils.deleteIndex(appid1);
		ElasticSearchUtils.deleteIndex(appid2);
		ElasticSearchUtils.deleteIndex(appid3);
	}

}