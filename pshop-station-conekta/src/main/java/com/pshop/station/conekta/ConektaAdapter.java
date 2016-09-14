
package com.pshop.station.conekta;

import java.util.List;

import com.pshop.station.conekta.service.RequestCharges;
import com.pshop.station.conekta.service.RequestChargesMSI;
import com.pshop.station.conekta.service.RequestPaymentCard;
import com.pshop.station.conekta.service.ResponseCharges;
import com.pshop.station.conekta.service.ResponseChargesMSI;
import com.pshop.station.conekta.service.ResponsePaymentCard;

/**
 *
 * @author gtrejo
 */
public interface ConektaAdapter {
    public ResponseCharges createChargeOxxo(RequestCharges requestCharges) throws Exception;
    public ResponseCharges getInfoChargeOxxo(String idOperation) throws Exception;
    public List<ResponseCharges> getAllChargesOxxo(String status) throws Exception;
    ResponsePaymentCard createChargeCard(RequestPaymentCard requestPaymentCard) throws Exception;
    ResponseChargesMSI createChargeCardMSI(RequestChargesMSI request) throws Exception;
    ResponseChargesMSI domiCreateChargeCardMSI(RequestChargesMSI request);
}
