import { BowlingGame } from './bowling-game'

describe('BowlingGame', () => {
  it('should return total score of 0 + 5 if a frame is either a spare or a strike', () => {
    const game = new BowlingGame()

    game.fromRecord('05')
    const roundScore = game.getFrameScore(1)

    expect(roundScore).toEqual(5)
  })

  it('should wait for next block if current round is a spare', () => {
    const game = new BowlingGame()

    game.fromRecord('0/')
    const roundScore = game.getFrameScore(1)

    expect(roundScore).toBeNull()
  })

  it('should count one more block if current round is a spare', () => {
    const game = new BowlingGame()

    game.fromRecord('0/ 50')
    const roundScore = game.getFrameScore(1)

    expect(roundScore).toBe(15)
  })

  it('should count one more block if current round is a spare', () => {
    const game = new BowlingGame()

    game.fromRecord('7/ 50')
    const roundScore = game.getFrameScore(1)

    expect(roundScore).toBe(15)
  })

  it('should wait for next two blocks if current round is a strike', () => {
    const game = new BowlingGame()

    game.fromRecord('X')
    const roundScore = game.getFrameScore(1)

    expect(roundScore).toBe(null)
  })

  it('should count two more block if current round is a strike', () => {
    const game = new BowlingGame()

    game.fromRecord('X 35')

    expect(game.getFrameScore(1)).toBe(18)
    expect(game.getFrameScore(2)).toBe(8)
  })

  it('should count two more block if current round is a strike', () => {
    const game = new BowlingGame()

    game.fromRecord('X 7/')

    expect(game.getFrameScore(1)).toBe(20)
    expect(game.getFrameScore(2)).toBe(null)
  })

  it('should return 30 for the first round if the first three frames are all strikes', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X')

    expect(game.getFrameScore(1)).toBe(30)
    expect(game.getFrameScore(2)).toBe(null)
  })

  it('should calculate three blocks for the 10th final frame', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X 222')

    expect(game.getFrameScore(9)).toBe(14)
    expect(game.getFrameScore(10)).toBe(6)
  })

  it('should calculate final frame if it has a spare and a non-strike', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X 8/8')

    expect(game.getFrameScore(9)).toBe(20)
    expect(game.getFrameScore(10)).toBe(18)
  })

  it('should calculate final frame if it has a spare and a strike', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X 8/X')

    expect(game.getFrameScore(9)).toBe(20)
    expect(game.getFrameScore(10)).toBe(20)
  })

  it('should calculate final frame if it is a strike and a non-spare', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X X81')

    expect(game.getFrameScore(9)).toBe(28)
    expect(game.getFrameScore(10)).toBe(19)
  })

  it('should calculate final frame if it is a strike and a spare', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X X8/')

    expect(game.getFrameScore(9)).toBe(28)
    expect(game.getFrameScore(10)).toBe(20)
  })

  it('should calculate final frame if it is three strikes', () => {
    const game = new BowlingGame()

    game.fromRecord('X X X X X X X X X XXX')

    expect(game.getFrameScore(9)).toBe(30)
    expect(game.getFrameScore(10)).toBe(30)
  })

  it('integration tests', () => {
    const game = new BowlingGame()

    game.fromRecord('35 27 4/ 5/ X 13 2/ 8/ X 5/9')

    expect(game.getTotalAsOfFrame(1)).toBe(8)
    expect(game.getTotalAsOfFrame(2)).toBe(17)
    expect(game.getTotalAsOfFrame(3)).toBe(32)
    expect(game.getTotalAsOfFrame(4)).toBe(52)
    expect(game.getTotalAsOfFrame(5)).toBe(66)
    expect(game.getTotalAsOfFrame(6)).toBe(70)
    expect(game.getTotalAsOfFrame(7)).toBe(88)
    expect(game.getTotalAsOfFrame(8)).toBe(108)
    expect(game.getTotalAsOfFrame(9)).toBe(128)
    expect(game.getTotalAsOfFrame(10)).toBe(147)
  })
})
