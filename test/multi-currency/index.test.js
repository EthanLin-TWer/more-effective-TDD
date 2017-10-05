import assert from 'assert'
import Dollar from '../../src/multi-currency'

describe('multiplication', () => {
  it('should return 10 when 5 times 2', () => {
    const five = new Dollar(5)
    const result = five.times(2)

    assert.equal(10, result.amount)
  })
})
