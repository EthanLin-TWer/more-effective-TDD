import * as assert from 'assert'
import Dollar from '../../src/multi-currency'

describe('multiplication', () => {
  it('should return 10 when 5 times 2', () => {
    const five = new Dollar(5)
    const product = five.times(2)

    assert(product.equals(new Dollar(10)))
  })

  it('should return 15 when 5 times 3', () => {
    const five = new Dollar(5)
    const product = five.times(3)

    assert(product.equals(new Dollar(15)))
  })
})

describe('money equality', () => {
  it('should return true when asking if $5 equals $5', () => {
    assert.equal(new Dollar(5).equals(new Dollar(5)), true)
  })

  it('should return false when asking if $5 equals $4', () => {
    assert.equal(new Dollar(5).equals(new Dollar(4)), false)
  })

  it('should return false when comparing with null money', () => {
    assert.equal(new Dollar(5).equals(null), false)
  })
})
