package contracts.order

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            request {
                method 'GET'
                url $(regex('/orders/customer/[0-9]+'))
            }
            response {
                status(OK())
                body([
                        [
                             customerId   : $(fromRequest().path(2)),
                             date         : $(anyDate()),
                             totalSum     : $(anyDouble()),
                             shippingAddress : [
                                   street : $(regex('[a-zA-Z\\s]+')),
                                   address: $(regex('[0-9]+/[0-9]+')),
                                   city   : $(regex('[a-zA-Z\\s]+'))
                             ]
                        ]
                ])
                headers {
                    contentType(applicationJsonUtf8())
                }
            }
        }
]