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

import bisq.asset.AddressValidationResult;
import bisq.asset.AddressValidator;
import bisq.asset.Coin;

import org.apache.commons.codec.binary.Base64;

public class Cruzbit extends Coin {

    public Cruzbit() {
        super("Cruzbit", "CRUZ", new CruzbitAddressValidator());
    }

    public static class CruzbitAddressValidator implements AddressValidator {
        private static final Base64 base64 = new Base64();
        private static final int publicKeySize = 32;

        public AddressValidationResult validate(String input) {
            if (!isValidAddress(input)) {
                return AddressValidationResult.invalidStructure();
            }
            return AddressValidationResult.validAddress();
        }

        private static boolean isValidAddress(String address) {
            byte[] encodedPublicKeyBytes = address.getBytes();
            if (!base64.isBase64(encodedPublicKeyBytes)) {
                return false;
            }

            byte[] publicKeyBytes = base64.decodeBase64(encodedPublicKeyBytes);
            if (publicKeyBytes.length != publicKeySize) {
                return false;
            }

            return true;
        }
    }
}
