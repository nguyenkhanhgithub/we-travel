package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role()}
     *   <li>{@link Role#setAccountList(List)}
     *   <li>{@link Role#setRoleId(Integer)}
     *   <li>{@link Role#setRoleName(String)}
     *   <li>{@link Role#getAccountList()}
     *   <li>{@link Role#getRoleId()}
     *   <li>{@link Role#getRoleName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Role actualRole = new Role();
        ArrayList<Account> accountList = new ArrayList<>();
        actualRole.setAccountList(accountList);
        actualRole.setRoleId(123);
        actualRole.setRoleName("Role Name");
        assertSame(accountList, actualRole.getAccountList());
        assertEquals(123, actualRole.getRoleId().intValue());
        assertEquals("Role Name", actualRole.getRoleName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role(Integer, String, List)}
     *   <li>{@link Role#setAccountList(List)}
     *   <li>{@link Role#setRoleId(Integer)}
     *   <li>{@link Role#setRoleName(String)}
     *   <li>{@link Role#getAccountList()}
     *   <li>{@link Role#getRoleId()}
     *   <li>{@link Role#getRoleName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Account> accountList = new ArrayList<>();
        Role actualRole = new Role(123, "Role Name", accountList);
        ArrayList<Account> accountList1 = new ArrayList<>();
        actualRole.setAccountList(accountList1);
        actualRole.setRoleId(123);
        actualRole.setRoleName("Role Name");
        List<Account> accountList2 = actualRole.getAccountList();
        assertSame(accountList1, accountList2);
        assertEquals(accountList, accountList2);
        assertEquals(123, actualRole.getRoleId().intValue());
        assertEquals("Role Name", actualRole.getRoleName());
    }
}

