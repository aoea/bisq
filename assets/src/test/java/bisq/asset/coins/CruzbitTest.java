/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.asset.coins;

import bisq.asset.AbstractAssetTest;

import org.junit.Test;

public class CruzbitTest extends AbstractAssetTest {

    public CruzbitTest() {
        super(new Cruzbit());
    }

    @Test
    public void testValidAddresses() {
        assertValidAddress("OjFShusc5o/9WHZopg2bg5hh9p+TrjIy6YnL0lz1DPA=");
        assertValidAddress("iqMQP2VqMoamzHkpRVt7Vl0VwkpAn/hhMJpxi4i7HFk=");
        assertValidAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=");
    }

    @Test
    public void testInvalidAddresses() {
        assertInvalidAddress("BD25iT+/6vJts3AxqBQt1v5Q/N69wvQ0jdZrqSiUFc4JWGsvIGeAvuU8xUsSLY3CwBG1RpeqnqzWpKKWyThOt0I=");
        assertInvalidAddress("g3uNf++dmOnp7adN+dkiYuH4i6gK8awNMbfXRjGT8mWl=");
        assertInvalidAddress("iqMQP2VqMoamzHkpRVt7Vl0VwkpAn/h MJpxi4i7HFk=");
    }
}
